package com.example.user.application;

/**
 * Created by User on 2017-01-13.
 */
public class DataModel {

    DataModel(int idx,int flavor_1, int flavor_2, int flavor_3, int flavor_4){
        this.idx = idx;
        this.flavor_1 = flavor_1;
        this.flavor_2 = flavor_2;
        this.flavor_3 = flavor_3;
        this.flavor_4 = flavor_4;

    }
    private int flavor_1;
    private int flavor_2;
    private int flavor_3;
    private int flavor_4;
    private int idx;

    public int getFlavor_1 ()
    {
        return flavor_1;
    }

    public void setFlavor_1 (int flavor_1)
    {
        this.flavor_1 = flavor_1;
    }

    public int getFlavor_2 ()
    {
        return flavor_2;
    }

    public void setFlavor_2 (int flavor_2)
    {
        this.flavor_2 = flavor_2;
    }

    public int getFlavor_3 ()
    {
        return flavor_3;
    }

    public void setFlavor_3 (int flavor_3)
    {
        this.flavor_3 = flavor_3;
    }

    public int getFlavor_4 ()
    {
        return flavor_4;
    }

    public void setFlavor_4 (int flavor_4)
    {
        this.flavor_4 = flavor_4;
    }

    public int getIdx (int idx)
    {
        return idx;
    }

    public void setIdx (int idx)
    {
        this.idx = idx;
    }
    @Override
    public String toString()
    {
        return "ClassPojo [idx = "+idx+"flavor_1 = "+flavor_1+", flavor_2 = "+flavor_2+", flavor_3 = "+flavor_3+", flavor_4 = "+flavor_4+"]";
    }
}