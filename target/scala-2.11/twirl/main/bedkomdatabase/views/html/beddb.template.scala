
package bedkomdatabase.views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
import bedkomdatabase.models.Bedrift
import profile.models.User
/**/
object beddb extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[java.util.List[bedkomdatabase.models.Bedrift],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(content: java.util.List[bedkomdatabase.models.Bedrift]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import java.util.Collections

Seq[Any](format.raw/*3.58*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.1*/("""<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2" style="margin-top: 1%">
            <div class="white-box">
                <div class="row">
                    <h1>Bedriftsdatabase:</h1>
                </div>
                <div class="row undershiit">
                    <div class="col-md-8 whitebox undershit col-md-offset-2">
                        <p class="text-center">
                            _________________________________________________________________________________
                        </p>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="clean-white-box well" style="border-radius: 0px; border-bottom: rgba(0, 0, 0 ,.1) solid">
                            <div class="col-md-5">
                                <p>Bedrift:</p>
                            </div>
                            <div class="col-md-3">
                                <p>Ansvarlig for kontakt:</p>
                            </div>
                            <div class="col-md-2">
                                <p>Prioritet:</p>
                            </div>
                            <div class="col-md-2">
                                <p>Status:</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="clean-white-box">
                            <div class="col-md-12">
                                    <!-- Button trigger modal, triggers bedrift creator -->
                                <button type="button" class="btn btn-primary btn-md center-block" data-toggle="modal" data-target="#myModal">
                                    Legg til bedrift i databasen
                                </button>

                                    <!-- Modal, Bedrift creator modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="myModalLabel">Opprett bedrift</h4>
                                            </div>
                                            <form name="Bedrift" action=""""),_display_(/*54.75*/bedkomdatabase/*54.89*/.routes.Bedkomdatabase.saveBedrift()),format.raw/*54.125*/("""" method="POST" enctype="multipart/form-data">
                                                <div class="modal-body">

                                                    <div class="form-group">
                                                        <label for="bedriftsName">Bedriftsnavn</label>
                                                        <input type="text" class="form-control" name="bedriftsName" id="bedriftsName" placeholder="Navn på Bedriften">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="webpage">Nettside</label>
                                                        <input type="text" class="form-control" name="webpage" id="webpage" placeholder="Nettside">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="priority">Prioritet</label>
                                                        <input type="number" class="form-control" name="priority" id="priority" placeholder="Prioritet" max="10" min="1">
                                                    </div>

                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    <input class="btn btn-primary" type="submit" value="Lagre bedrift">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="border-bottom: rgba(0,0,0,.1) solid">
                    """),_display_(/*83.22*/for(i <- content) yield /*83.39*/{_display_(Seq[Any](format.raw/*83.40*/("""
                        """),format.raw/*84.25*/("""<div class="row">
                                <!-- Button trigger modal, triggers bedrift info popup -->
                            <div class="clean-white-box div_pointer" data-toggle="modal" data-target="#"""),_display_(/*86.105*/i/*86.106*/.getBedriftId),format.raw/*86.119*/("""">
                                <div class="col-md-5">
                                    <p>"""),_display_(/*88.41*/i/*88.42*/.getBedriftName),format.raw/*88.57*/("""</p>
                                </div>
                                <div class="col-md-3">
                                    <p>"""),_display_(/*91.41*/i/*91.42*/.getResponsible().getFullName()),format.raw/*91.73*/("""</p>
                                </div>
                                <div class="col-md-2">
                                    <p>"""),_display_(/*94.41*/i/*94.42*/.getPriority),format.raw/*94.54*/("""</p>
                                </div>
                                <div class="col-md-2">
                                    """),_display_(/*97.38*/if(i.isActive)/*97.52*/{_display_(Seq[Any](format.raw/*97.53*/("""
                                        """),format.raw/*98.41*/("""<div class="progress">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                                <span class="sr-only">100% Complete (success)</span>
                                            </div>
                                        </div>""")))}),format.raw/*102.48*/("""
                                    """),_display_(/*103.38*/if(!i.isActive)/*103.53*/{_display_(Seq[Any](format.raw/*103.54*/("""
                                        """),format.raw/*104.41*/("""<div class="progress">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                                <span class="sr-only">0% Complete (success)</span>
                                            </div>
                                        </div>
                                    """)))}),format.raw/*109.38*/("""
                                """),format.raw/*110.33*/("""</div>
                            </div>


                                <!-- Modal for presenting Bedrift Data -->
                            <div class="modal fade" id=""""),_display_(/*115.58*/i/*115.59*/.getBedriftId),format.raw/*115.72*/("""" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header div_pointer" data-toggle="collapse" data-parent="#accordion" href="#collapseEdit"""),_display_(/*118.147*/i/*118.148*/.getBedriftId),format.raw/*118.161*/("""" aria-expanded="true" aria-controls="collapseEdit"""),_display_(/*118.212*/i/*118.213*/.getBedriftId),format.raw/*118.226*/("""" id="headingEdit"""),_display_(/*118.244*/i/*118.245*/.getBedriftId),format.raw/*118.258*/("""">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">"""),_display_(/*120.88*/i/*120.89*/.getBedriftName),format.raw/*120.104*/("""</h4>
                                        </div>
                                        <div id="collapseEdit"""),_display_(/*122.63*/i/*122.64*/.getBedriftId),format.raw/*122.77*/("""" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEdit"""),_display_(/*122.156*/i/*122.157*/.getBedriftId),format.raw/*122.170*/("""">
                                                <!--- Form for editing Bedrift -->
                                            <div class="panel panel-heading">
                                                <form name="editBedrift" action=""""),_display_(/*125.83*/bedkomdatabase/*125.97*/.routes.Bedkomdatabase.updateBedrift(i.getBedriftId.toString)),format.raw/*125.158*/("""" method="POST" enctype="multipart/form-data">
                                                    <div class="modal-body">

                                                        <div class="form-group">
                                                            <label for="bedriftsName">Bedriftsnavn</label>
                                                            <input type="text" class="form-control" name="bedriftsName" id="bedriftsName" placeholder="Navn på Bedriften" value=""""),_display_(/*130.179*/i/*130.180*/.getBedriftName),format.raw/*130.195*/("""">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="priority">Prioritet</label>
                                                            <input type="number" class="form-control" name="priority" id="priority" placeholder="Prioritet" max="10" min="1" value=""""),_display_(/*134.182*/i/*134.183*/.getPriority),format.raw/*134.195*/("""">
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="webpage">Nettside</label>
                                                            <input type="text" class="form-control" name="webpage" id="webpage placeholder="Bedriftens nettside" value=""""),_display_(/*139.170*/i/*139.171*/.getWebpage),format.raw/*139.182*/("""">
                                                        </div>

                                                        <div class="form-group">
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio" name="active" id="active1" value="true" """),_display_(/*145.130*/if(i.isActive)/*145.144*/{_display_(Seq[Any](format.raw/*145.145*/("""checked""")))}),format.raw/*145.153*/(""">
                                                                    Aktiv
                                                                </label>
                                                            </div>
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio" name="active" id="active2" value="false" """),_display_(/*151.131*/if(!i.isActive)/*151.146*/{_display_(Seq[Any](format.raw/*151.147*/("""checked""")))}),format.raw/*151.155*/(""">
                                                                    Inaktiv
                                                                </label>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="userSelect">Ansvarlig bruker</label>
                                                            <select class="form-control" name="userId" id="userId">
                                                                """),_display_(/*160.66*/for(user <- User.find.where().eq("bedkom", true).findList()) yield /*160.126*/{_display_(Seq[Any](format.raw/*160.127*/("""
                                                                    """),format.raw/*161.69*/("""<option value=""""),_display_(/*161.85*/user/*161.89*/.getId),format.raw/*161.95*/("""" """),_display_(/*161.98*/if(i.getResponsible.equals(user))/*161.131*/{_display_(Seq[Any](format.raw/*161.132*/("""selected="selected"""")))}),format.raw/*161.152*/("""> """),_display_(/*161.155*/user/*161.159*/.getFullName),format.raw/*161.171*/("""</option>
                                                                """)))}),format.raw/*162.66*/("""
                                                            """),format.raw/*163.61*/("""</select>
                                                        </div>

                                                        <button type="submit" class="btn btn-primary form-control">Lagre</button>

                                                    </div>
                                                </form>
                                                <div class="modal-body">
                                                    <div class="btn btn-danger form-control" data-toggle="collapse" data-parent="#accordion" href="#collapseDanger"""),_display_(/*171.164*/i/*171.165*/.getBedriftId),format.raw/*171.178*/("""" aria-expanded="true" aria-controls="collapseDanger"""),_display_(/*171.231*/i/*171.232*/.getBedriftId),format.raw/*171.245*/("""" id="headingDanger"""),_display_(/*171.265*/i/*171.266*/.getBedriftId),format.raw/*171.279*/("""">
                                                    Slett
                                                    </div>

                                                    <div id="collapseDanger"""),_display_(/*175.77*/i/*175.78*/.getBedriftId),format.raw/*175.91*/("""" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingDanger"""),_display_(/*175.172*/i/*175.173*/.getBedriftId),format.raw/*175.186*/("""">
                                                        <form action=""""),_display_(/*176.72*/bedkomdatabase/*176.86*/.routes.Bedkomdatabase.deleteBedrift(i.getBedriftId.toString)),format.raw/*176.147*/("""" method="POST">
                                                            <button type="submit" class="btn btn-danger form-control">
                                                            Er du sikker?
                                                            </button>
                                                        </form>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-body">
                                            <!--- Bedriftsinfo -->
                                            <p class="text-center">Nettside: <a href=""""),_display_(/*188.88*/i/*188.89*/.getWebpage),format.raw/*188.100*/("""" target="_blank">"""),_display_(/*188.119*/i/*188.120*/.getWebpage),format.raw/*188.131*/("""</a></p>
                                            <p class="text-center">Bedrift opprettet: """),_display_(/*189.88*/i/*189.89*/.getDateMade),format.raw/*189.101*/("""</p>
                                            <p class="text-center">Sist oppdatert: """),_display_(/*190.85*/i/*190.86*/.getWhenUpdated),format.raw/*190.101*/("""</p>
                                        </div>
                                            <!--- Kontaktpersoner -->
                                        <div class="modal-body">
                                            <div class="center-block">
                                                <p class="text-center">Kontakpersoner:</p></div>
                                            """),_display_(/*196.46*/for(p <- i.getContacts) yield /*196.69*/ {_display_(Seq[Any](format.raw/*196.71*/("""
                                                """),format.raw/*197.49*/("""<div class="row">
                                                    <div class="col-md-10 col-md-offset-1">
                                                        <div class="panel panel-default">
                                                            <div class="panel-heading div_pointer" data-toggle="collapse" data-parent="#accordion" href="#collapseCEdit"""),_display_(/*200.169*/p/*200.170*/.getContactId),format.raw/*200.183*/("""" aria-expanded="true" aria-controls="collapseEdit"""),_display_(/*200.234*/p/*200.235*/.getContactId),format.raw/*200.248*/("""" id="headingEdit"""),_display_(/*200.266*/p/*200.267*/.getContactId),format.raw/*200.280*/("""">
                                                            """),_display_(/*201.62*/p/*201.63*/.getContact),format.raw/*201.74*/("""
                                                            """),format.raw/*202.61*/("""</div>
                                                            <div id="collapseCEdit"""),_display_(/*203.84*/p/*203.85*/.getContactId),format.raw/*203.98*/("""" class="panel-body panel-collapse collapse" role="tabpanel" aria-labelledby="headingCEdit"""),_display_(/*203.189*/p/*203.190*/.getContactId),format.raw/*203.203*/("""">
                                                                    <!--- FORM FOR EDITING CONTACT GOES HERE!!! -->
                                                                <form action=""""),_display_(/*205.80*/bedkomdatabase/*205.94*/.routes.Bedkomdatabase.updateKontaktPerson(p.getContactId.toString)),format.raw/*205.161*/("""" method="POST" enctype="multipart/form-data">
                                                                    <div class="form-group">
                                                                        <label for="kontaktName">Navn på kontakt</label>
                                                                        <input type="text" class="form-control" name="contact" id="kontaktName" placeholder="Navn på kontakten" value=""""),_display_(/*208.185*/p/*208.186*/.getContact),format.raw/*208.197*/("""">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="telephone">Telefonnummer</label>
                                                                        <input type="text" class="form-control" name="telephone" id="telephone" placeholder="Telefonnummer" value=""""),_display_(/*212.181*/p/*212.182*/.getTelephone),format.raw/*212.195*/("""">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="email">email</label>
                                                                        <input type="email" class="form-control" name="email" id="email" placeholder="Email(at)bedrift.no" value=""""),_display_(/*216.180*/p/*216.181*/.getEmail),format.raw/*216.190*/("""">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="other">Annen info</label>
                                                                        <input type="text" class="form-control" name="other" id="other" placeholder="Annen info" value=""""),_display_(/*220.170*/p/*220.171*/.getOther),format.raw/*220.180*/("""">
                                                                    </div>
                                                                    <button type="submit" class="btn btn-primary form-control">Oppdater kontaktperson</button>
                                                                </form>
                                                                <div class="btn btn-danger form-control" data-toggle="collapse" data-parent="#accordion" href="#collapseKDanger"""),_display_(/*224.177*/p/*224.178*/.getContactId),format.raw/*224.191*/("""" aria-expanded="true" aria-controls="collapseKDanger"""),_display_(/*224.245*/p/*224.246*/.getContactId),format.raw/*224.259*/("""" id="headingKDanger"""),_display_(/*224.280*/p/*224.281*/.getContactId),format.raw/*224.294*/("""">
                                                    Slett
                                                                </div>

                                                                <div id="collapseKDanger"""),_display_(/*228.90*/p/*228.91*/.getContactId),format.raw/*228.104*/("""" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingKDanger"""),_display_(/*228.186*/p/*228.187*/.getContactId),format.raw/*228.200*/("""">
                                                                    <form action=""""),_display_(/*229.84*/bedkomdatabase/*229.98*/.routes.Bedkomdatabase.deleteKontaktPerson(p.getContactId.toString)),format.raw/*229.165*/("""" method="POST">
                                                                        <button type="submit" class="btn btn-danger form-control">
                                                            Er du sikker?
                                                                        </button>
                                                                    </form>

                                                                </div>
                                                            </div>
                                                            <div class="panel-body">
                                                            Telefon: """),_display_(/*238.71*/p/*238.72*/.getTelephone),format.raw/*238.85*/(""" """),format.raw/*238.86*/("""<br>
                                                                Email: """),_display_(/*239.73*/p/*239.74*/.getEmail),format.raw/*239.83*/(""" """),format.raw/*239.84*/("""<br>
                                                                Annet: """),_display_(/*240.73*/p/*240.74*/.getOther),format.raw/*240.83*/(""" """),format.raw/*240.84*/("""<br>
                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            """)))}),format.raw/*245.46*/("""
                                            """),format.raw/*246.45*/("""<div class="row">
                                                <div class="col-md-10 col-md-offset-1">
                                                    <div class="panel panel-primary">
                                                        <div class="panel-heading" role="tab" id="heading"""),_display_(/*249.107*/i/*249.108*/.getBedriftId),format.raw/*249.121*/("""">
                                                            <h4 class="panel-title">
                                                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse"""),_display_(/*251.146*/i/*251.147*/.getBedriftId),format.raw/*251.160*/("""" aria-expanded="true" aria-controls="collapse"""),_display_(/*251.207*/i/*251.208*/.getBedriftId),format.raw/*251.221*/("""">
                                                        Opprett ny kontaktperson:
                                                                </a>
                                                            </h4>
                                                        </div>
                                                        <div id="collapse"""),_display_(/*256.75*/i/*256.76*/.getBedriftId),format.raw/*256.89*/("""" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading"""),_display_(/*256.164*/i/*256.165*/.getBedriftId),format.raw/*256.178*/("""">
                                                            <div class="panel-body">
                                                                <form action=""""),_display_(/*258.80*/bedkomdatabase/*258.94*/.routes.Bedkomdatabase.saveKontaktPerson(i.getBedriftId.toString)),format.raw/*258.159*/("""" method="POST" enctype="multipart/form-data">
                                                                    <div class="form-group">
                                                                        <label for="kontaktName">Navn på kontakt</label>
                                                                        <input type="text" class="form-control" name="contact" id="kontaktName" placeholder="Navn på kontakten">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="telephone">Telefonnummer</label>
                                                                        <input type="text" class="form-control" name="telephone" id="telephone" placeholder="Telefonnummer">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="email">email</label>
                                                                        <input type="email" class="form-control" name="email" id="email" placeholder="Email(at)bedrift.no">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="other">Annen info</label>
                                                                        <input type="text" class="form-control" name="other" id="other" placeholder="Annen info">
                                                                    </div>
                                                                    <button type="submit" class="btn btn-primary form-control">Legg til kontaktperson</button>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div></div>
                                            </div>
                                            <div class="row">
                                                <div class="center-block">
                                                    <p class="text-center">Notater:</p>
                                                </div>
                                            </div>
                                            <div class="row">
                                                    <!-- LIST NOTATER-->
                                                <div class="col-md-10 col-md-offset-1">
                                                    """),_display_(/*289.54*/for(k <- i.getNotes) yield /*289.74*/{_display_(Seq[Any](format.raw/*289.75*/("""
                                                        """),format.raw/*290.57*/("""<div class="panel panel-default">
                                                            <div class="panel-heading div_pointer" data-toggle="collapse" data-parent="#accordion" href="#collapseNEdit"""),_display_(/*291.169*/k/*291.170*/.getNoteId),format.raw/*291.180*/("""" aria-expanded="true" aria-controls="collapseNEdit"""),_display_(/*291.232*/k/*291.233*/.getNoteId),format.raw/*291.243*/("""" id="headingNEdit"""),_display_(/*291.262*/k/*291.263*/.getNoteId),format.raw/*291.273*/("""">
                                                                <h4 class="panel-title">
                                                                """),_display_(/*293.66*/k/*293.67*/.getDateMade()),format.raw/*293.81*/("""
                                                                """),format.raw/*294.65*/("""</h4>
                                                            </div>
                                                            <div id="collapseNEdit"""),_display_(/*296.84*/k/*296.85*/.getNoteId),format.raw/*296.95*/("""" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingNEdit"""),_display_(/*296.175*/k/*296.176*/.getNoteId),format.raw/*296.186*/("""">
                                                                <div class="panel-body">
                                                                    <form action=""""),_display_(/*298.84*/bedkomdatabase/*298.98*/.routes.Bedkomdatabase.updateNote(k.getNoteId.toString)),format.raw/*298.153*/("""" method="POST" enctype="multipart/form-data">
                                                                        <div class="form-group">
                                                                            <label for="note">Notat</label>
                                                                            <textarea type="text" class="form-control" name="note" id="note" placeholder="Ditt notat her" >"""),_display_(/*301.173*/k/*301.174*/.getNote),format.raw/*301.182*/("""</textarea>
                                                                        </div>
                                                                        <button type="submit" class="btn btn-primary form-control" > Lagre notat </button>
                                                                    </form>
                                                                    <div class="btn btn-danger form-control" data-toggle="collapse" data-parent="#accordion" href="#collapseNDanger"""),_display_(/*305.181*/k/*305.182*/.getNoteId),format.raw/*305.192*/("""" aria-expanded="true" aria-controls="collapseNDanger"""),_display_(/*305.246*/k/*305.247*/.getNoteId),format.raw/*305.257*/("""" id="headingNDanger"""),_display_(/*305.278*/k/*305.279*/.getNoteId),format.raw/*305.289*/("""">
                                                    Slett
                                                                    </div>

                                                                    <div id="collapseNDanger"""),_display_(/*309.94*/k/*309.95*/.getNoteId),format.raw/*309.105*/("""" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingNDanger"""),_display_(/*309.187*/k/*309.188*/.getNoteId),format.raw/*309.198*/("""">
                                                                        <form action=""""),_display_(/*310.88*/bedkomdatabase/*310.102*/.routes.Bedkomdatabase.deleteNote(k.getNoteId.toString)),format.raw/*310.157*/("""" method="POST">
                                                                            <button type="submit" class="btn btn-danger form-control">
                                                            Er du sikker?
                                                                            </button>
                                                                        </form>

                                                                    </div>


                                                                </div>
                                                            </div>
                                                            <div class="panel-body">
                                                            """),_display_(/*322.62*/k/*322.63*/.getNote),format.raw/*322.71*/("""
                                                            """),format.raw/*323.61*/("""</div>
                                                        </div>

                                                    """)))}),format.raw/*326.54*/("""
                                                """),format.raw/*327.49*/("""<div class="panel panel-primary">
                                                    <div class="panel-heading" role="tab" id="headingNotes"""),_display_(/*328.108*/i/*328.109*/.getBedriftId),format.raw/*328.122*/("""">
                                                        <h4 class="panel-title">
                                                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseNotes"""),_display_(/*330.147*/i/*330.148*/.getBedriftId),format.raw/*330.161*/("""" aria-expanded="true" aria-controls="collapseNotes"""),_display_(/*330.213*/i/*330.214*/.getBedriftId),format.raw/*330.227*/("""">
                                                        Opprett nytt notat:
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapseNotes"""),_display_(/*335.76*/i/*335.77*/.getBedriftId),format.raw/*335.90*/("""" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingNotes"""),_display_(/*335.170*/i/*335.171*/.getBedriftId),format.raw/*335.184*/("""">
                                                        <div class="panel-body">
                                                            <form action=""""),_display_(/*337.76*/bedkomdatabase/*337.90*/.routes.Bedkomdatabase.saveNote(i.getBedriftId.toString)),format.raw/*337.146*/("""" method="POST" enctype="multipart/form-data">
                                                                <div class="form-group">
                                                                    <label for="note">Notat</label>
                                                                    <textarea type="text" class="form-control" name="note" id="note" placeholder="Ditt notat her"></textarea>
                                                                </div>
                                                                <button type="submit" class="btn btn-primary form-control">Lagre notat</button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>

                                                </div>
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    """)))}),format.raw/*359.22*/("""</div>
                </div>
            </div>
        </div>
    </div>
</div>

"""))}
  }

  def render(content:java.util.List[bedkomdatabase.models.Bedrift]): play.twirl.api.HtmlFormat.Appendable = apply(content)

  def f:((java.util.List[bedkomdatabase.models.Bedrift]) => play.twirl.api.HtmlFormat.Appendable) = (content) => apply(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/bedkomdatabase/views/beddb.scala.html
                  HASH: c32f6b2e4ee7931f596c0861de3a9e0f629e50f0
                  MATRIX: 840->69|1012->125|1040->158|1068->160|3895->2960|3918->2974|3976->3010|6144->5151|6177->5168|6216->5169|6270->5195|6513->5410|6524->5411|6559->5424|6686->5524|6696->5525|6732->5540|6901->5682|6911->5683|6963->5714|7132->5856|7142->5857|7175->5869|7341->6008|7364->6022|7403->6023|7473->6065|7920->6480|7987->6519|8012->6534|8052->6535|8123->6577|8603->7025|8666->7059|8875->7240|8886->7241|8921->7254|9300->7604|9312->7605|9348->7618|9428->7669|9440->7670|9476->7683|9523->7701|9535->7702|9571->7715|9860->7976|9871->7977|9909->7992|10054->8109|10065->8110|10100->8123|10208->8202|10220->8203|10256->8216|10533->8465|10557->8479|10641->8540|11166->9036|11178->9037|11216->9052|11677->9484|11689->9485|11724->9497|12173->9917|12185->9918|12219->9929|12683->10364|12708->10378|12749->10379|12790->10387|13323->10891|13349->10906|13390->10907|13431->10915|14121->11577|14199->11637|14240->11638|14339->11708|14383->11724|14397->11728|14425->11734|14456->11737|14500->11770|14541->11771|14594->11791|14626->11794|14641->11798|14676->11810|14784->11886|14875->11948|15468->12512|15480->12513|15516->12526|15598->12579|15610->12580|15646->12593|15695->12613|15707->12614|15743->12627|15972->12828|15983->12829|16018->12842|16128->12923|16140->12924|16176->12937|16279->13012|16303->13026|16387->13087|17203->13875|17214->13876|17248->13887|17296->13906|17308->13907|17342->13918|17467->14015|17478->14016|17513->14028|17631->14118|17642->14119|17680->14134|18114->14540|18154->14563|18195->14565|18274->14615|18674->14986|18686->14987|18722->15000|18802->15051|18814->15052|18850->15065|18897->15083|18909->15084|18945->15097|19038->15162|19049->15163|19082->15174|19173->15236|19292->15327|19303->15328|19338->15341|19458->15432|19470->15433|19506->15446|19734->15646|19758->15660|19848->15727|20325->16175|20337->16176|20371->16187|20872->16659|20884->16660|20920->16673|21408->17132|21420->17133|21452->17142|21935->17596|21947->17597|21979->17606|22497->18095|22509->18096|22545->18109|22628->18163|22640->18164|22676->18177|22726->18198|22738->18199|22774->18212|23028->18438|23039->18439|23075->18452|23186->18534|23198->18535|23234->18548|23349->18635|23373->18649|23463->18716|24174->19399|24185->19400|24220->19413|24250->19414|24356->19492|24367->19493|24398->19502|24428->19503|24534->19581|24545->19582|24576->19591|24606->19592|24933->19887|25008->19933|25338->20234|25350->20235|25386->20248|25650->20483|25662->20484|25698->20497|25774->20544|25786->20545|25822->20558|26212->20920|26223->20921|26258->20934|26362->21009|26374->21010|26410->21023|26607->21192|26631->21206|26719->21271|29718->24242|29755->24262|29795->24263|29882->24321|30114->24524|30126->24525|30159->24535|30240->24587|30252->24588|30285->24598|30333->24617|30345->24618|30378->24628|30565->24787|30576->24788|30612->24802|30707->24868|30893->25026|30904->25027|30936->25037|31045->25117|31057->25118|31090->25128|31295->25305|31319->25319|31397->25374|31853->25801|31865->25802|31896->25810|32431->26316|32443->26317|32476->26327|32559->26381|32571->26382|32604->26392|32654->26413|32666->26414|32699->26424|32961->26658|32972->26659|33005->26669|33116->26751|33128->26752|33161->26762|33280->26853|33305->26867|33383->26922|34177->27688|34188->27689|34218->27697|34309->27759|34468->27886|34547->27936|34718->28078|34730->28079|34766->28092|35027->28324|35039->28325|35075->28338|35156->28390|35168->28391|35204->28404|35577->28749|35588->28750|35623->28763|35732->28843|35744->28844|35780->28857|35969->29018|35993->29032|36072->29088|37572->30556
                  LINES: 27->3|30->3|31->5|32->6|80->54|80->54|80->54|109->83|109->83|109->83|110->84|112->86|112->86|112->86|114->88|114->88|114->88|117->91|117->91|117->91|120->94|120->94|120->94|123->97|123->97|123->97|124->98|128->102|129->103|129->103|129->103|130->104|135->109|136->110|141->115|141->115|141->115|144->118|144->118|144->118|144->118|144->118|144->118|144->118|144->118|144->118|146->120|146->120|146->120|148->122|148->122|148->122|148->122|148->122|148->122|151->125|151->125|151->125|156->130|156->130|156->130|160->134|160->134|160->134|165->139|165->139|165->139|171->145|171->145|171->145|171->145|177->151|177->151|177->151|177->151|186->160|186->160|186->160|187->161|187->161|187->161|187->161|187->161|187->161|187->161|187->161|187->161|187->161|187->161|188->162|189->163|197->171|197->171|197->171|197->171|197->171|197->171|197->171|197->171|197->171|201->175|201->175|201->175|201->175|201->175|201->175|202->176|202->176|202->176|214->188|214->188|214->188|214->188|214->188|214->188|215->189|215->189|215->189|216->190|216->190|216->190|222->196|222->196|222->196|223->197|226->200|226->200|226->200|226->200|226->200|226->200|226->200|226->200|226->200|227->201|227->201|227->201|228->202|229->203|229->203|229->203|229->203|229->203|229->203|231->205|231->205|231->205|234->208|234->208|234->208|238->212|238->212|238->212|242->216|242->216|242->216|246->220|246->220|246->220|250->224|250->224|250->224|250->224|250->224|250->224|250->224|250->224|250->224|254->228|254->228|254->228|254->228|254->228|254->228|255->229|255->229|255->229|264->238|264->238|264->238|264->238|265->239|265->239|265->239|265->239|266->240|266->240|266->240|266->240|271->245|272->246|275->249|275->249|275->249|277->251|277->251|277->251|277->251|277->251|277->251|282->256|282->256|282->256|282->256|282->256|282->256|284->258|284->258|284->258|315->289|315->289|315->289|316->290|317->291|317->291|317->291|317->291|317->291|317->291|317->291|317->291|317->291|319->293|319->293|319->293|320->294|322->296|322->296|322->296|322->296|322->296|322->296|324->298|324->298|324->298|327->301|327->301|327->301|331->305|331->305|331->305|331->305|331->305|331->305|331->305|331->305|331->305|335->309|335->309|335->309|335->309|335->309|335->309|336->310|336->310|336->310|348->322|348->322|348->322|349->323|352->326|353->327|354->328|354->328|354->328|356->330|356->330|356->330|356->330|356->330|356->330|361->335|361->335|361->335|361->335|361->335|361->335|363->337|363->337|363->337|385->359
                  -- GENERATED --
              */
          