hibernate-jpa-api
=================

*Deprecated*

Please use `javax.persistence:javax.persistence-api:2.2` since JPA 2.2.

This repository used to host a clean-room definition of JPA APIs intended for transitory use in Hibernate JPA development,
however this is no longer necessary since JPA 2.2 as the API created by the JPA working group is now publicly available.

The versions for JPA 2.1 and previous are available in the maintenance branches.
See http://java.net/projects/jpa-spec/downloads for drafts used to create them.

The current "master" branch is going to be repurposed to publish Maven Relocation artifacts so to help everyone to migrate to
the standard APIs.

Reminder about the release process:

> mvn -B release:clean release:prepare release:perform -Dtag=JPA2.2_[version] -DreleaseVersion=version -DdevelopmentVersion=Z
> git push upstream HEAD
> git push upstream <tag name>


