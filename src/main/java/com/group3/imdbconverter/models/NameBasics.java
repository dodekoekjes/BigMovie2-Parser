package com.group3.imdbconverter.models;


import java.util.List;

import com.group3.imdbconverter.types.*;

//Builder patern
// name basics model
public final class NameBasics
{
   private ImdbId m_id;
   private ImdbString m_primaryName;
   private ImdbInt m_birthYear;
   private ImdbInt m_deathYear;
   private List<ImdbString> m_primaryProfessions;
   private List<ImdbId> m_knownForTitles;


   private NameBasics()
   {
   }

   public ImdbId id()
   {
      return m_id;
   }

   public ImdbString primaryName()
   {
      return m_primaryName;
   }

   public ImdbInt birthYear()
   {
      return m_birthYear;
   }

   public ImdbInt deathYear()
   {
      return m_deathYear;
   }

   public List<ImdbString> primaryProfessions()
   {
      return m_primaryProfessions;
   }

   public List<ImdbId> knownForTitles()
   {
      return m_knownForTitles;
   }

// builder class
   public static final class Builder
   {
      private NameBasics m_build = new NameBasics();


      private Builder()
      {
      }

      public Builder id(ImdbId id)
      {
         m_build.m_id = id;
         return this;
      }

      public Builder primaryName(ImdbString primaryName)
      {
         m_build.m_primaryName = primaryName;
         return this;
      }

      public Builder birthYear(ImdbInt birthYear)
      {
         m_build.m_birthYear = birthYear;
         return this;
      }

      public Builder deathYear(ImdbInt deathYear)
      {
         m_build.m_deathYear = deathYear;
         return this;
      }

      public Builder primaryProfessions(List<ImdbString> primaryProfessions)
      {
         m_build.m_primaryProfessions = primaryProfessions;
         return this;
      }

      public Builder knownForTitles(List<ImdbId> knownForTitles)
      {
         m_build.m_knownForTitles = knownForTitles;
         return this;
      }

      public NameBasics build()
      {
         return m_build;
      }
   }


   public static Builder builder()
   {
      return new Builder();
   }
}
