package com.group3.imdbconverter.writers;


public abstract class ImdbWriter<T>
{
   public abstract boolean write(T model);
}
