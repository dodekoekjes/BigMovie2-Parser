package com.group3.imdbconverter.models;


import java.util.List;

import com.group3.imdbconverter.types.*;

//Builder patern
// title basiscs model
public final class TitleBasics
{
   private ImdbId m_id;
   private ImdbString m_titleType;
   private ImdbString m_primaryTitle;
   private ImdbString m_originalTitle;
   private ImdbBool m_isAdult;
   private ImdbInt m_startYear;
   private ImdbInt m_endYear;
   private ImdbInt m_runtimeMinutes;
   private List<ImdbString> m_genres;


   private TitleBasics()
   {
   }

   public ImdbId id()
   {
      return m_id;
   }

   public ImdbString titleType()
   {
      return m_titleType;
   }

   public ImdbString primaryTitle()
   {
      return m_primaryTitle;
   }

   public ImdbString originalTitle()
   {
      return m_originalTitle;
   }

   public ImdbBool isAdult()
   {
      return m_isAdult;
   }

   public ImdbInt startYear()
   {
      return m_startYear;
   }

   public ImdbInt endYear()
   {
      return m_endYear;
   }

   public ImdbInt runtimeMinutes()
   {
      return m_runtimeMinutes;
   }

   public List<ImdbString> genres()
   {
      return m_genres;
   }


   public static final class Builder
   {
      private TitleBasics m_build = new TitleBasics();


      private Builder()
      {
      }

      public Builder id(ImdbId id)
      {
         m_build.m_id = id;
         return this;
      }

      public Builder titleType(ImdbString titleType)
      {
         m_build.m_titleType = titleType;
         return this;
      }

      public Builder primaryTitle(ImdbString primaryTitle)
      {
         m_build.m_primaryTitle = primaryTitle;
         return this;
      }

      public Builder originalTitle(ImdbString originalTitle)
      {
         m_build.m_originalTitle = originalTitle;
         return this;
      }

      public Builder isAdult(ImdbBool isAdult)
      {
         m_build.m_isAdult = isAdult;
         return this;
      }

      public Builder startYear(ImdbInt startYear)
      {
         m_build.m_startYear = startYear;
         return this;
      }

      public Builder endYear(ImdbInt endYear)
      {
         m_build.m_endYear = endYear;
         return this;
      }

      public Builder runtimeMinutes(ImdbInt runtimeMinutes)
      {
         m_build.m_runtimeMinutes = runtimeMinutes;
         return this;
      }

      public Builder genres(List<ImdbString> genres)
      {
         m_build.m_genres = genres;
         return this;
      }

      public TitleBasics build()
      {
         return m_build;
      }
   }


   public static Builder builder()
   {
      return new Builder();
   }
}
