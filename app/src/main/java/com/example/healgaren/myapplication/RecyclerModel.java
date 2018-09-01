package com.example.healgaren.myapplication;

public class RecyclerModel {
    private int viewType;
    private Object model;

    public RecyclerModel(int viewType, Object model) {
        this.viewType = viewType;
        this.model = model;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }
}
