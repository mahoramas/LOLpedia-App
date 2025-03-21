# Casos de usos

![Diagrama de Casos de Uso](/images/diagrama_casos_uso.drawio.png)

## Actores

### Usuario sin cuenta

# **Actores**  

## **Usuario sin cuenta**  
| Actor | Usuario sin cuenta |
|---|---|
| **Descripción** | Es un usuario que aún no ha creado una cuenta en la plataforma. Puede realizar acciones limitadas. |
| **Características** | Puede registrarse y recuperar su contraseña . |
| **Relaciones** | |
| **Referencias** | Página de inicio. |
| **Notas** | Solo tiene acceso limitado a ciertas funciones de la aplicación. |
| **Autor** | mahoramas |
| **Fecha** | 20/03/2025 |

---

## **Usuario con cuenta**  
| Actor | Usuario con cuenta |
|---|---|
| **Descripción** | Es un usuario que ya ha creado una cuenta y tiene acceso a más funciones en la plataforma. |
| **Características** | Puede iniciar sesión, leer entradas, añadir favoritos, cambiar su nombre de perfil, cambiar su contraseña y mandar sugerencias. |
| **Relaciones** |  |
| **Referencias** | Panel de usuario, libreria de informacion, ajustes de cuenta. |
| **Notas** | Debe recordar sus credenciales o utilizar la opción de recuperación de contraseña. |
| **Autor** | mahoramas |
| **Fecha** | 20/03/2025 |

---

## **Administrador**  
| Actor | Administrador |
|---|---|
| **Descripción** | Es el usuario con permisos avanzados para modificar información en la plataforma. |
| **Características** | Puede realizar todas las acciones de un usuario normal y modificar información. |
| **Relaciones** |  |
| **Referencias** | Panel de administración, módulo de gestión de usuarios. |
| **Notas** | Tiene acceso a herramientas avanzadas que pueden afectar el sistema. |
| **Autor** | mahoramas |
| **Fecha** | 20/03/2025 |

---

# **Casos de Uso**  

## **Registrarse**  
| Caso de Uso CU1 | Registrarse |
|---|---|
| **Fuentes** | |
| **Actor** | Usuario sin cuenta |
| **Descripción** | Permite a un nuevo usuario registrarse en la plataforma para acceder a más funcionalidades. |
| **Flujo básico** | 1. El usuario accede a la pantalla de registro.2. Introduce los datos requeridos (nombre, correo, contraseña).3. Confirma el registro.4. El sistema valida la información y crea la cuenta. |
| **Flujo alternativo** | 2a. Si falta algún dato obligatorio, el sistema muestra un mensaje de error.3a. Si el correo ya está registrado, el sistema solicita otro. |
| **Pre-condiciones** | El usuario no debe tener una cuenta previa. |
| **Post-condiciones** | El usuario tiene una cuenta creada y puede iniciar sesión. |
| **Requerimientos** | Base de datos de usuarios, validación de correo electrónico. |
| **Notas** | Se debe verificar la cuenta. |
| **Autor** | mahoramas |
| **Fecha** | 20/03/2025 |

---

## **Recuperar Contraseña**  
| Caso de Uso CU2 | Recuperar Contraseña |
|---|---|
| **Fuentes** | |
| **Actor** | Usuario sin cuenta, Usuario con cuenta |
| **Descripción** | Permite a los usuarios recuperar el acceso a su cuenta si olvidaron su contraseña. |
| **Flujo básico** | 1. El usuario accede a la opción "Recuperar contraseña".2. Introduce su correo electrónico.3. El sistema envía un enlace de recuperación.4. El usuario sigue el enlace y crea una nueva contraseña. |
| **Flujo alternativo** | 2a. Si el correo no está registrado, el sistema muestra un mensaje de error. |
| **Pre-condiciones** | El usuario debe tener un correo registrado. |
| **Post-condiciones** | La contraseña del usuario se actualiza. |
| **Requerimientos** | Servicio de correo electrónico, validación de identidad. |
| **Notas** | La contraseña debe cumplir con requisitos mínimos de seguridad. |
| **Autor** | mahoramas |
| **Fecha** | 20/03/2025 |

---

## **Mandar Sugerencia**  
| Caso de Uso CU3 | Leer entradas |
|---|---|
| **Fuentes** | |
| **Actor** | Usuario con cuenta, Administrador |
| **Descripción** | Permite a un usuario con cuenta leer las entradas de la plataforma. |
| **Flujo básico** | 1. El usuario accede a la biblioteca. 2. El usuario selecciona la informacion que quiere |
| **Pre-condiciones** | El usuario debe tener cuenta. |
| **Post-condiciones** | El usuario es dirgido a la informacion que quiere visualizar |
| **Requerimientos** | Base de datos. |
| **Notas** |  |
| **Autor** | mahoramas |
| **Fecha** | 20/03/2025 |

---

## **Mandar Sugerencia**  
| Caso de Uso CU4 | Mandar Sugerencia |
|---|---|
| **Fuentes** | Requisitos funcionales del sistema |
| **Actor** | Usuario con cuenta |
| **Descripción** | Permite a un usuario con cuenta enviar sugerencias para mejorar la plataforma. |
| **Flujo básico** | 1. El usuario accede a la opción "Enviar sugerencia".2. Introduce el mensaje con su sugerencia.3. Confirma el envío.4. El sistema almacena la sugerencia y la envía a los administradores. |
| **Flujo alternativo** | 2a. Si el mensaje está vacío, el sistema muestra un error. |
| **Pre-condiciones** | El usuario debe estar autenticado. |
| **Post-condiciones** | La sugerencia es almacenada y visible para los administradores. |
| **Requerimientos** | Base de datos de sugerencias, notificación a administradores. |
| **Notas** | Se podría implementar un sistema de respuesta a sugerencias en el futuro. |
| **Autor** | mahoramas |
| **Fecha** | 20/03/2025 |

---

## **Modificar Información**  
| Caso de Uso CU5 | Modificar Información |
|---|---|
| **Fuentes** | Requisitos funcionales del sistema |
| **Actor** | Administrador |
| **Descripción** | Permite a los administradores modificar contenido dentro de la plataforma. |
| **Flujo básico** | 1. El administrador accede al panel de administración.2. Selecciona la opción para modificar información.3. Realiza los cambios necesarios.4. Guarda la nueva información. |
| **Flujo alternativo** | 3a. Si los datos ingresados son incorrectos, el sistema muestra un mensaje de error. |
| **Pre-condiciones** | El administrador debe estar autenticado. |
| **Post-condiciones** | La información modificada queda reflejada en la plataforma. |
| **Requerimientos** | Permisos administrativos, validación de cambios. |
| **Notas** | Se debe registrar quién realizó la modificación para auditoría. |
| **Autor** | mahoramas |
| **Fecha** | 20/03/2025 |

---
