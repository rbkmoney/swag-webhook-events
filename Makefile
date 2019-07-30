all: compile

init:
	npm install

build:
	npm run build

# Java

MVN = mvn -s $(SETTINGS_XML) -Dcommit.number="$(NUMBER_COMMITS)"

java.swag.compile_client_old:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
	$(MVN) compile -P="client-old"

java.swag.deploy_client_old:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
	$(MVN) versions:set versions:commit -DnewVersion="$(JAVA_PKG_VERSION)-client-old" && \
	$(MVN) deploy -P="client-old"

java.swag.install_client_old:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
    $(MVN) versions:set versions:commit -DnewVersion="$(JAVA_PKG_VERSION)-client-old" && \
    $(MVN) install -P="client-old"

java.swag.compile_client:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
	$(MVN) compile -P="client"

java.swag.deploy_client:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
	$(MVN) versions:set versions:commit -DnewVersion="$(JAVA_PKG_VERSION)-client" && \
	$(MVN) deploy -P="client"

java.swag.install_client:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
    $(MVN) versions:set versions:commit -DnewVersion="$(JAVA_PKG_VERSION)-client" && \
    $(MVN) install -P="client"

java.swag.compile_server:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
	$(MVN) compile -P="server"

java.swag.deploy_server:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
	$(MVN) versions:set versions:commit -DnewVersion="$(JAVA_PKG_VERSION)-server" && \
	$(MVN) deploy -P="server"

java.swag.install_server:
	$(if $(SETTINGS_XML),,echo "SETTINGS_XML not defined" ; exit 1)
	$(MVN) clean && \
    $(MVN) versions:set versions:commit -DnewVersion="$(JAVA_PKG_VERSION)-server" && \
    $(MVN) install -P="server"

java.compile: java.settings
	$(MVN) compile

java.deploy: java.settings
	$(MVN) versions:set versions:commit -DnewVersion="$(JAVA_PKG_VERSION)" && \
	$(MVN) deploy

java.install: java.settings
	$(MVN) clean && \
	$(MVN) versions:set versions:commit -DnewVersion="$(JAVA_PKG_VERSION)" && \
	$(MVN) install

java.settings:
	$(if $(SETTINGS_XML),, echo "SETTINGS_XML not defined"; exit 1)
