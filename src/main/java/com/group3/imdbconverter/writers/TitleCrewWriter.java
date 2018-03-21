package com.group3.imdbconverter.writers;


import java.io.IOException;
import java.io.PrintWriter;

import com.group3.imdbconverter.models.TitleCrew;
import com.group3.imdbconverter.types.*;


public final class TitleCrewWriter extends ImdbWriter<TitleCrew>
{
   private PrintWriter m_titleCrewWriter;
   private PrintWriter m_crewWriter;
   private PrintWriter m_writerWriter;


   public TitleCrewWriter(String path)
      throws IOException
   {
      m_titleCrewWriter = new PrintWriter(path + "title.crew.csv");
      m_crewWriter = new PrintWriter(path + "title.crew.crew.csv");
      m_writerWriter = new PrintWriter(path + "title.crew.writer.csv");
   }

   @Override
   public boolean write(TitleCrew model)
   {
      m_titleCrewWriter.println(model.id());

      String data;
      for (ImdbId directorId : model.directors())
      {
         data = String.format("\"%s\",\"%s\",\"%s\"",
            model.id(),
            model.titleId(),
            directorId);

         m_crewWriter.println(data);
      }
      for (ImdbId writerId : model.writers())
      {
         data = String.format("\"%s\",\"%s\",\"%s\"",
            model.id(),
            model.titleId(),
            writerId);

         m_writerWriter.println(data);
      }

      return true;
   }
}
