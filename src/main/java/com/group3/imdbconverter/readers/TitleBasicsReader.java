package com.group3.imdbconverter.readers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.group3.imdbconverter.models.TitleBasics;
import com.group3.imdbconverter.types.*;


public final class TitleBasicsReader extends ImdbReader<TitleBasics>
{
   private BufferedReader m_reader;


   public TitleBasicsReader(String filename)
      throws IOException
   {
      m_reader = new BufferedReader(new FileReader(filename));
   }

   @Override
   public TitleBasics read()
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

      return TitleBasics.builder()
         .id(ImdbId.parse(fields[0]))
         .titleType(ImdbString.parse(fields[1]))
         .primaryTitle(ImdbString.parse(fields[2]))
         .originalTitle(ImdbString.parse(fields[3]))
         .isAdult(ImdbBool.parse(fields[4]))
         .startYear(ImdbInt.parse(fields[5]))
         .endYear(ImdbInt.parse(fields[6]))
         .runtimeMinutes(ImdbInt.parse(fields[7]))
         .genres(ImdbArray.map(fields[8], ImdbString::parse))
         .build();
   }
}
