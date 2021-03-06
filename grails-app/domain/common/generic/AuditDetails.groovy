package common.generic

import common.change_control.Contribution
import common.change_control.Version
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAccessType

//@XmlAccessorType(XmlAccessType.FIELD)
class AuditDetails {

   // Identificador del sistema al que fue commiteado el cambio en el EHR
   String systemId = "ISIS_EHR" // FIXME: debe salir de config
   
   // Lo establece el servidor cuando recibe un commit
   Date timeCommitted
   
   // Sera siempre "creation" porque no hay edicion
   String changeType = "creation" // otros valores: deleted, amendment, modification, attestation, addition
   
   DoctorProxy committer
   
   static constraints = {
   }
   
   // Para que Contribution salve su AuditDetails en cascada
   static belongsTo = [Contribution, Version]
}