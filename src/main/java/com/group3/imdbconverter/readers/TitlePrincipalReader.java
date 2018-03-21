package com.group3.imdbconverter.readers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.group3.imdbconverter.models.*;
import com.group3.imdbconverter.types.*;


public final class TitlePrincipalReader extends ImdbReader<TitlePrincipal>
{
   private BufferedReader m_reader;
   private int m_counter;


   public TitlePrincipalReader(String filename)
      throws IOException
   {
      m_reader = new BufferedReader(new FileReader(filename));
   }

   @Override
   public TitlePrincipal read()
   {
      String line = null;
      try
      {
         line = m_reader.readLine();
      }
      catch (IOException ex)
      {
         return null;
      }

      if (line == null)
      {
         return null;
      }

      String[] fields = line.split("\t");

      return TitlePrincipal.builder()
         .id(ImdbId.from(m_counter++))
         .m_titleId(ImdbId.parse(fields[0]))
         .principalCast(ImdbArray.map(fields[1], ImdbId::parse))
         .build();
   }
}
