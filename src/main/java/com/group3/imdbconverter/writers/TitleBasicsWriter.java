package com.group3.imdbconverter.writers;


import java.io.IOException;
import java.io.PrintWriter;

import com.group3.imdbconverter.models.TitleBasics;
import com.group3.imdbconverter.types.*;


public final class TitleBasicsWriter extends ImdbWriter<TitleBasics>
{
   private PrintWriter m_titleWriter;
   private PrintWriter m_titleTypeWriter;
   private PrintWriter m_genreWriter;


   public TitleBasicsWriter(String path)
      throws IOException
   {
      m_titleWriter = new PrintWriter(path + "title.basics.csv");
    //   m_titleTypeWriter = new PrintWriter(path + "title.basics.type.csv");
    //   m_genreWriter = new PrintWriter(path + "title.basics.genre.csv");
   }

   @Override
   public boolean write(TitleBasics model)
   {
      String data = String.format("\"%s\",%s,%s,%s,\"%s,%s\",\"%s\",\"%s\"",
         model.id(),
         model.primaryTitle(),
         model.originalTitle(),
         model.titleType(), /* test */
         model.isAdult(),
         model.startYear(),
         model.endYear(),
         model.runtimeMinutes());

      m_titleWriter.println(data);

    //   data = String.format("%s,\"%s\"",
    //      model.id(),
    //      model.titleType());

    //   m_titleTypeWriter.println(model.titleType());

    //   for (ImdbString genre : model.genres())
    //   {
    //      data = String.format("\"%s\",%s",
    //         model.id(),
    //         genre);

    //      m_genreWriter.println(data);
    //   }

      return true;
   }
}
