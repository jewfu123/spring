package org.keycloak.userstorage;


import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;
import org.keycloak.storage.UserStorageProviderFactory;
import org.keycloak.userstorage.domain.Constants;
import org.keycloak.userstorage.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomUserStorageProviderFactory implements UserStorageProviderFactory<CustomUserStorageProvider> {

    private final Logger logger = LoggerFactory.getLogger(CustomUserStorageProviderFactory.class);

    private final PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();

    @Override
    public CustomUserStorageProvider create(KeycloakSession session, ComponentModel model) {
        // 在这设置用户存储提供程序，启动一些连接。
        return new CustomUserStorageProvider(session, model);
    }

    @Override
    public String getId() {
        String id = propertiesUtil.getStrPropertyValue(Constants.PROVIDER_NAME);
        logger.info("CustomUserStorageProviderFactory::getId: {} ", id);
        return id;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return ProviderConfigurationBuilder.create()
                .property()
                .name(Constants.DB_DRIVER_CLASS)
                .type(ProviderConfigProperty.STRING_TYPE)
                .label("DB Connection Driver")
                .defaultValue(propertiesUtil.getStrPropertyValue(Constants.DB_DRIVER_CLASS))
                .add()

                .property()
                .name(Constants.DB_URL)
                .type(ProviderConfigProperty.STRING_TYPE)
                .label("Jdbc URL")
                .defaultValue(propertiesUtil.getStrPropertyValue(Constants.DB_URL))
                .helpText("Jdbc Url ?")
                .add()

                .property()
                .name(Constants.DB_USERNAME)
                .type(ProviderConfigProperty.STRING_TYPE)
                .label("DB UserName")
                .defaultValue(propertiesUtil.getStrPropertyValue(Constants.DB_USERNAME))
                .add()

                .property()
                .name(Constants.DB_PASSWORD)
                .type(ProviderConfigProperty.STRING_TYPE)
                .label("DB Password")
                .defaultValue(propertiesUtil.getStrPropertyValue(Constants.DB_PASSWORD))
                .add()

                .property()
                .name(Constants.DB_MAX_POOL_SIZE)
                .type(ProviderConfigProperty.STRING_TYPE)
                .label("DB MAX POOL SIZE")
                .defaultValue(propertiesUtil.getStrPropertyValue(Constants.DB_MAX_POOL_SIZE))
                .add()
                .build();
    }


}
