package com.group3.imdbconverter.readers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.group3.imdbconverter.models.TitleCrew;
import com.group3.imdbconverter.types.*;


public final class TitleCrewReader extends ImdbReader<TitleCrew>
{
   private BufferedReader m_reader;
   private int m_counter;


   public TitleCrewReader(String filename)
      throws IOException
   {
      m_reader = new BufferedReader(new FileReader(filename));
   }

   @Override
   public TitleCrew read()
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

      return TitleCrew.builder()
         .id(ImdbId.from(m_counter++))
         .titleId(ImdbId.parse(fields[0]))
         .directors(ImdbArray.map(fields[1], ImdbId::parse))
         .writers(ImdbArray.map(fields[2], ImdbId::parse))
         .build();
   }
}
