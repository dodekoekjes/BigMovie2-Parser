package com.group3.imdbconverter.models;


import com.group3.imdbconverter.types.*;

// Title episodes model
// with builder patern
public final class TitleEpisode
{
   private ImdbId m_id;
   private ImdbId m_parentId;
   private ImdbInt m_seasonNumber;
   private ImdbInt m_episodeNumber;


   private TitleEpisode()
   {
   }

   public ImdbId id()
   {
      return m_id;
   }

   public ImdbId parentId()
   {
      return m_parentId;
   }

   public ImdbInt seasonNumber()
   {
      return m_seasonNumber;
   }

   public ImdbInt episodeNumber()
   {
      return m_episodeNumber;
   }

// builder patern
   public static final class Builder
   {
      private TitleEpisode m_build = new TitleEpisode();


      private Builder()
      {
      }

      public Builder id(ImdbId id)
      {
         m_build.m_id = id;
         return this;
      }

      public Builder parentId(ImdbId parentId)
      {
         m_build.m_parentId = parentId;
         return this;
      }

      public Builder seasonNumber(ImdbInt seasonNumber)
      {
         m_build.m_seasonNumber = seasonNumber;
         return this;
      }

      public Builder episodeNumber(ImdbInt episodeNumber)
      {
         m_build.m_episodeNumber = episodeNumber;
         return this;
      }

      public TitleEpisode build()
      {
         return m_build;
      }
   }


   public static Builder builder()
   {
      return new Builder();
   }
}
