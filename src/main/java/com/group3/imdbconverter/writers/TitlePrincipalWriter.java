package com.group3.imdbconverter.writers;


import java.io.IOException;
import java.io.PrintWriter;

import com.group3.imdbconverter.models.TitlePrincipal;
import com.group3.imdbconverter.types.ImdbId;


public final class TitlePrincipalWriter extends ImdbWriter<TitlePrincipal>
{
   private PrintWriter m_titlePrincipalWriter;


   public TitlePrincipalWriter(String output)
      throws IOException
   {
      m_titlePrincipalWriter = new PrintWriter(output + "title.principals.csv");
   }

   @Override
   public boolean write(TitlePrincipal model)
   {
      for (ImdbId principalId : model.principalCast())
      {
         String data = String.format("\"%s\",\"%s\",\"%s\"",
            model.id(),
            model.titleId(),
            principalId);

         m_titlePrincipalWriter.println(data);
      }

      return true;
   }
}
