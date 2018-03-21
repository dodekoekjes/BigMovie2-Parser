package com.group3.imdbconverter.writers;


import java.io.IOException;
import java.io.PrintWriter;

import com.group3.imdbconverter.models.TitleRating;


public final class TitleRatingWriter extends ImdbWriter<TitleRating>
{
   private PrintWriter m_titleRatingWriter;


   public TitleRatingWriter(String path)
      throws IOException
   {
      m_titleRatingWriter = new PrintWriter(path + "title.ratings.csv");
   }

   @Override
   public boolean write(TitleRating model)
   {
      String data = String.format("\"%s\",\"%s\",\"%s\",\"%s\"",
         model.id(),
         model.titleId(),
         model.averageRating(),
         model.numVotes());

      m_titleRatingWriter.println(data);

      return true;
   }
}
