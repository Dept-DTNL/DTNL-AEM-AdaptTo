package com.deptagency.dtnl.aem.adaptto.core.services.impl;

import com.deptagency.dtnl.aem.adaptto.core.models.EnvironmentEnum;
import com.deptagency.dtnl.aem.adaptto.core.models.RunModesEnum;
import com.deptagency.dtnl.aem.adaptto.core.services.RunModeService;
import com.deptagency.dtnl.aem.adaptto.core.services.config.RunModeServiceConfig;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = RunModeService.class)
@Designate(ocd = RunModeServiceConfig.class)
public class RunModeServiceImpl implements RunModeService {

    private RunModeServiceConfig config;

    @Activate
    protected void activate(final RunModeServiceConfig config) {
        this.config = config;
    }

    @Override
    public RunModesEnum getRunMode() {
        if(config == null || StringUtils.isBlank(config.runMode())){
            return RunModesEnum.AUTHOR;
        }
        return RunModesEnum.fromString(config.runMode());
    }

    @Override
    public EnvironmentEnum getEnvironment() {
        if(config == null || StringUtils.isBlank(config.environment())){
            return EnvironmentEnum.DEV;
        }
        return EnvironmentEnum.fromString(config.environment());
    }
}
