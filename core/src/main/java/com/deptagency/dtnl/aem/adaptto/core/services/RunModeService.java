package com.deptagency.dtnl.aem.adaptto.core.services;

import com.deptagency.dtnl.aem.adaptto.core.models.EnvironmentEnum;
import com.deptagency.dtnl.aem.adaptto.core.models.RunModesEnum;

public interface RunModeService {

    RunModesEnum getRunMode();

    EnvironmentEnum getEnvironment();
}
