package com.qixin.app.wobble.service;

import com.qixin.app.wobble.model.Wobbleconfig;

public interface WobbleconfigService
{
    public abstract String updateWobbleconfig(Wobbleconfig wobbleconfig)
            throws Exception;

    public Wobbleconfig getWobbleconfigByName(String name) throws Exception;

    public abstract String addWobbleconfig(Wobbleconfig wobbleconfig)
            throws Exception;
}
