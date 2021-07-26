# Apuntes enunciado

## Requerimientos

F01. user login: NOT done
F02. show info (avance, cobertura, número de centros, personas vacunadas parcialmente, personas vacunadas completamente): 
F03. crear un centro de vacunación: DONE (addCenter)
F04. eliminar un centro de vacunación: DONE (removeCenter)
F05. user logout: NOT done
F06. visualizar porcentaje por categoría*: NOT done
N01. allows use of 50 centers simultaneously: threadPoolSize = 50
N02. 2s answers: execution time works
N03. 3s notify: execution time works

\* 22.935.533 personas:

- de 80 a más (647.355)
- de 70 a 79 (1.271.842)
- de 60 a 69 (2.221.241)
- de 50 a 59 (3.277.134)
- de 40 a 49 (4.183.174)
- de 30 a 39 (5.031.117)
- de 18 a 29 (6.303.670)

## Análisis

- Patrón observer donde cada usuario es un observador.
- Hay múltiples publishers (centros) manejados por un solo sistema. Los usuarios se subscriben a estos.
- Patrón singleton donde se utiliza un solo centro de notificaciones de vacunación.
