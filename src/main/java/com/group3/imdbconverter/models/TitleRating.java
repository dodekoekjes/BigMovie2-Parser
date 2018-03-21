package com.group3.imdbconverter.models;

import com.group3.imdbconverter.types.*;

// title rating model with builder patern
public final class TitleRating
{
   private ImdbId m_id;
   private ImdbId m_titleId;
   private ImdbDouble m_averageRating;
   private ImdbInt m_numVotes;


   private TitleRating()
   {
   }

   public ImdbId id()
   {
      return m_id;
   }

   public ImdbId titleId()
   {
      return m_titleId;
   }

   public ImdbDouble averageRating()
   {
      return m_averageRating;
   }

   public ImdbInt numVotes()
   {
      return m_numVotes;
   }


   public static final class Builder
   {
      private TitleRating m_build = new TitleRating();


      private Builder()
      {
      }

      public Builder id(ImdbId id)
      {
         m_build.m_id = id;
         return this;
      }

      public Builder titleId(ImdbId titleId)
      {
         m_build.m_titleId = titleId;
         return this;
      }

      public Builder averageRating(ImdbDouble averageRating)
      {
         m_build.m_averageRating = averageRating;
         return this;
      }

      public Builder numVotes(ImdbInt numVotes)
      {
         m_build.m_numVotes = numVotes;
         return this;
      }

      public TitleRating build()
      {
         return m_build;
      }
   }


   public static Builder builder()
   {
      return new Builder();
   }
}
