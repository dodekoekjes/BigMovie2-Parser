package com.group3.imdbconverter.models;


import java.util.List;

import com.group3.imdbconverter.types.*;

// with builder patern
// Title crew model
public final class TitleCrew
{
   private ImdbId m_id;
   private ImdbId m_titleId;
   private List<ImdbId> m_directors;
   private List<ImdbId> m_writers;


   private TitleCrew()
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

   public List<ImdbId> directors()
   {
      return m_directors;
   }

   public List<ImdbId> writers()
   {
      return m_writers;
   }


   public static final class Builder
   {
      private TitleCrew m_build = new TitleCrew();


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

      public Builder directors(List<ImdbId> directors)
      {
         m_build.m_directors = directors;
         return this;
      }

      public Builder writers(List<ImdbId> writers)
      {
         m_build.m_writers = writers;
         return this;
      }

      public TitleCrew build()
      {
         return m_build;
      }
   }


   public static Builder builder()
   {
      return new Builder();
   }
}
