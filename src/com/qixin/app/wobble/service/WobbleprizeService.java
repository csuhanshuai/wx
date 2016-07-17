package com.qixin.app.wobble.service;

import java.util.List;

import com.qixin.app.wobble.model.Wobbleprize;

public interface WobbleprizeService
{
    public abstract Wobbleprize getPrizeByid(String id, String bid)
            throws Exception;

    public abstract List<Wobbleprize> getPrizeBybid(String bid)
            throws Exception;

    public abstract String updatePrize(Wobbleprize prize) throws Exception;
}
