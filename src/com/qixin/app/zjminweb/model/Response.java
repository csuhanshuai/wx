package com.qixin.app.zjminweb.model;

public class Response<T>
{
    private String result;

    private T t;

    private String message;

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public T getT()
    {
        return t;
    }

    public void setT(T t)
    {
        this.t = t;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Constructs a <code>String</code> with all attributes in name = value
     * format.
     * 
     * @return a <code>String</code> representation of this object.
     */
    public String toString()
    {
        final String TAB = "    ";

        String retValue = "";

        retValue = "Response ( " + super.toString() + TAB + "result = "
                + this.result + TAB + "t = " + this.t + TAB + "message = "
                + this.message + TAB + " )";

        return retValue;
    }

}
