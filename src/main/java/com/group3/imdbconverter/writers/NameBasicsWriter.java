package com.group3.imdbconverter.writers;


import java.io.IOException;
import java.io.PrintWriter;

import com.group3.imdbconverter.types.*;
import com.group3.imdbconverter.models.NameBasics;


public final class NameBasicsWriter extends ImdbWriter<NameBasics>
{
   private PrintWriter m_nameBasicsWriter;
   private PrintWriter m_professionWriter;
   private PrintWriter m_titleWriter;


   public NameBasicsWriter(String path)
      throws IOException
   {
      m_nameBasicsWriter = new PrintWriter(path + "name.basics.csv");
      m_professionWriter = new PrintWriter(path + "name.basics.profession.csv");
      m_titleWriter = new PrintWriter(path + "name.basics.title.csv");
   }

   @Override
   public boolean write(NameBasics model)
   {
      String data = String.format("\"%s\",%s,\"%s\",\"%s\"",
         model.id(),
         model.primaryName(),
         model.birthYear(),
         model.deathYear());

      m_nameBasicsWriter.println(data);

      for (ImdbString profession : model.primaryProfessions())
      {
         data = String.format("\"%s\",%s",
            model.id(),
            profession);

         m_professionWriter.println(data);
      }

      for (ImdbId titleId : model.knownForTitles())
      {
         data = String.format("\"%s\",\"%s\"",
            model.id(),
            titleId);

         m_titleWriter.println(data);
      }

      return true;
   }
}
