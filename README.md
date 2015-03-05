GestionAbsence
==============

## prérequis de deployement ##

- Un serveur Jboss 7.1.1 démarré
- La DataSource suivante
```xml <datasource jta="true" jndi-name="java:/MySqlDS2" pool-name="MySqlDS_Pool2" 
enabled="true">
                    <connection-url>jdbc:mysql://localhost:3306/projetAbsenceTest</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>root</user-name>
                    </security>
                </datasource>
```