package com.group3.imdbconverter.writers;


import java.io.IOException;
import java.io.PrintWriter;

import com.group3.imdbconverter.models.TitleEpisode;


public final class TitleEpisodeWriter extends ImdbWriter<TitleEpisode>
{
   private PrintWriter m_titleEpisodeWriter;


   public TitleEpisodeWriter(String path)
      throws IOException
   {
      m_titleEpisodeWriter = new PrintWriter(path + "title.episode.csv");
   }

   @Override
   public boolean write(TitleEpisode model)
   {
      String data = String.format("\"%s\",\"%s\",\"%s\",\"%s\"",
         model.id(),
         model.parentId(),
         model.seasonNumber(),
         model.episodeNumber());

      m_titleEpisodeWriter.println(data);

      return true;
   }
}
