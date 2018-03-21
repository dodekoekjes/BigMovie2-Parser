package com.group3.imdbconverter.readers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.group3.imdbconverter.models.*;
import com.group3.imdbconverter.types.*;


public final class TitleRatingReader extends ImdbReader<TitleRating>
{
   private BufferedReader m_reader;
   private int m_counter;


   public TitleRatingReader(String filename)
      throws IOException
   {
      m_reader = new BufferedReader(new FileReader(filename));
   }

   @Override
   public TitleRating read()
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

      return TitleRating.builder()
         .id(ImdbId.from(m_counter++))
         .titleId(ImdbId.parse(fields[0]))
         .averageRating(ImdbDouble.parse(fields[1]))
         .numVotes(ImdbInt.parse(fields[2]))
         .build();
   }
}
