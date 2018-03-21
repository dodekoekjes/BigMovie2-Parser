package com.group3.imdbconverter.base;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.group3.imdbconverter.readers.ImdbReader;
import com.group3.imdbconverter.writers.ImdbWriter;


public class Converter implements Runnable
{
   private ImdbReader m_reader;
   private ImdbWriter m_writer;


   private Converter(ImdbReader reader, ImdbWriter writer)
   {
      m_reader = reader;
      m_writer = writer;
   }
// run function
   public void run()
   {
      Object model = null;
      while ((model = m_reader.read()) != null)
      {
         m_writer.write(model);
      }
   }

   public void start()
   {
      new Thread(this);
   }


   public static final class Conversion
   {
      private List<Converter> m_converters = new ArrayList<>();

    // add reader function
      public Conversion add(ImdbReader reader, ImdbWriter writer)
      {
         m_converters.add(new Converter(reader, writer));
         return this;
      }
      // start function Conversision
      public void start()
      {
        // Using mulitreading for faster csv export
         ExecutorService service = Executors.newCachedThreadPool();

         for (Converter conv : m_converters)
         {
            service.execute(conv);
         }
         try
         {
            service.awaitTermination(1, TimeUnit.DAYS);
         }
         catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }


   public static Conversion conversions()
   {
      return new Conversion();
   }
}
