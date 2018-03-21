package com.group3.imdbconverter.types;


public final class ImdbInt extends ImdbType<Integer>
{
   public static ImdbInt parse(String str)
   {
      ImdbInt ret = new ImdbInt();

      if (str.equals("\\N"))
      {
         ret.m_empty = true;
         return ret;
      }

      int val = 0;
      for (int i = 0; i < str.length(); ++i)
      {
         char c = str.charAt(i);

         if (c < 48 || c > 57)
         {
            ret.m_empty = true;
            return ret;
         }

         val = val * 10 + c - 48;
      }

      ret.m_value = val;
      return ret;
   }
}
