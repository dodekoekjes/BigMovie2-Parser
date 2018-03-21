package com.group3.imdbconverter.readers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.group3.imdbconverter.models.NameBasics;
import com.group3.imdbconverter.types.*;


public final class NameBasicsReader extends ImdbReader<NameBasics>
{
   private BufferedReader m_reader;


   public NameBasicsReader(String filename)
      throws IOException
   {
      m_reader = new BufferedReader(new FileReader(filename));
   }

   @Override
   public NameBasics read()
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

      return NameBasics.builder()
         .id(ImdbId.parse(fields[0]))
         .primaryName(ImdbString.parse(fields[1]))
         .birthYear(ImdbInt.parse(fields[2]))
         .deathYear(ImdbInt.parse(fields[3]))
         .primaryProfessions(ImdbArray.map(fields[4], ImdbString::parse))
         .knownForTitles(ImdbArray.map(fields[5], ImdbId::parse))
         .build();
   }
}
