package com.group3.imdbconverter.readers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.group3.imdbconverter.models.TitleEpisode;
import com.group3.imdbconverter.types.*;


public final class TitleEpisodeReader extends ImdbReader<TitleEpisode>
{
   private BufferedReader m_reader;


   public TitleEpisodeReader(String filename)
      throws IOException
   {
      m_reader = new BufferedReader(new FileReader(filename));
   }

   @Override
   public TitleEpisode read()
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

      return TitleEpisode.builder()
         .id(ImdbId.parse(fields[0]))
         .parentId(ImdbId.parse(fields[1]))
         .seasonNumber(ImdbInt.parse(fields[2]))
         .episodeNumber(ImdbInt.parse(fields[3]))
         .build();
   }
}
