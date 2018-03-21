package com.group3.imdbconverter.models;


import java.util.List;

import com.group3.imdbconverter.types.*;

// builder patern
// TitlePrincipal model
public final class TitlePrincipal
{
   private ImdbId m_id;
   private ImdbId m_titleId;
   private List<ImdbId> m_principalCast;


   private TitlePrincipal()
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

   public List<ImdbId> principalCast()
   {
      return m_principalCast;
   }


   public static final class Builder
   {
      private TitlePrincipal m_build = new TitlePrincipal();


      private Builder()
      {
      }

      public Builder id(ImdbId id)
      {
         m_build.m_id = id;
         return this;
      }

      public Builder m_titleId(ImdbId titleId)
      {
         m_build.m_titleId = titleId;
         return this;
      }

      public Builder principalCast(List<ImdbId> principalCast)
      {
         m_build.m_principalCast = principalCast;
         return this;
      }

      public TitlePrincipal build()
      {
         return m_build;
      }
   }


   public static Builder builder()
   {
      return new Builder();
   }
}
