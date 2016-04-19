// @SOURCE:C:/Users/Bendik/hybridaweb2-play/conf/routes
// @HASH:d0246b3de7f4152330da6028174b011e5844c533
// @DATE:Tue Apr 19 17:37:41 CEST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:188
// @LINE:187
// @LINE:184
// @LINE:9
// @LINE:8
// @LINE:5
package application {

// @LINE:188
// @LINE:187
// @LINE:184
// @LINE:9
// @LINE:8
// @LINE:5
class ReverseApplication {


// @LINE:188
def show404(anything:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("anything", anything))
}
                        

// @LINE:5
def untrail(path:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("path", path) + "/")
}
                        

// @LINE:187
def show400(error:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "error400/" + implicitly[PathBindable[String]].unbind("error", dynamicString(error)))
}
                        

// @LINE:8
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:9
def forside(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "forside")
}
                        

// @LINE:184
def showUnauthorizedAccess(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "unauthorized")
}
                        

}
                          
}
                  

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
package staticpages {

// @LINE:30
class ReverseTillitsvalgte {


// @LINE:30
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tillitsvalgte")
}
                        

}
                          

// @LINE:31
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:16
// @LINE:13
class ReverseAbout {


// @LINE:26
def redaksjonen(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "redaksjonen")
}
                        

// @LINE:24
def jentekom(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "jentekom")
}
                        

// @LINE:31
def vevkom(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "vevkom")
}
                        

// @LINE:25
def newStudent(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "nystudent")
}
                        

// @LINE:29
def styret(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "styret")
}
                        

// @LINE:13
def arrkom(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "arrkom")
}
                        

// @LINE:21
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "info")
}
                        

// @LINE:16
def bedkom(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "bedkom")
}
                        

}
                          

// @LINE:23
// @LINE:22
// @LINE:17
// @LINE:15
class ReverseRingen {


// @LINE:23
def about(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "i&iktringen/om")
}
                        

// @LINE:17
def ekskursjoner(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ekskursjoner")
}
                        

// @LINE:15
def bedriftspresentasjoner(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "bedriftspresentasjon")
}
                        

// @LINE:22
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "i&iktringen")
}
                        

}
                          

// @LINE:14
class ReverseBedrift {


// @LINE:14
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "bedrift")
}
                        

}
                          

// @LINE:27
class ReverseStatutter {


// @LINE:27
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "statutter")
}
                        

}
                          
}
                  

// @LINE:119
// @LINE:118
// @LINE:117
package rfid {

// @LINE:119
// @LINE:118
// @LINE:117
class ReverseRFIDReader {


// @LINE:118
def indexContinue(status:String, number:String, eventId:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "rfid/" + implicitly[PathBindable[String]].unbind("status", dynamicString(status)) + "/" + implicitly[PathBindable[String]].unbind("number", dynamicString(number)) + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("eventId", eventId)))))
}
                        

// @LINE:117
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "rfid")
}
                        

// @LINE:119
def read(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "rfid")
}
                        

}
                          
}
                  

// @LINE:10
package test {

// @LINE:10
class ReverseTestDatabase {


// @LINE:10
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "insertqt")
}
                        

}
                          
}
                  

// @LINE:20
// @LINE:19
// @LINE:18
package griffensorden {

// @LINE:20
// @LINE:19
// @LINE:18
class ReverseGriffensOrden {


// @LINE:18
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "griffensorden")
}
                        

// @LINE:20
def nomination(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "griffensorden/nominasjon")
}
                        

// @LINE:19
def riddere(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "griffensorden/riddere")
}
                        

}
                          
}
                  

// @LINE:122
package renders {

// @LINE:122
class ReverseSearch {


// @LINE:122
def search(term:String = "", page:Int = 0): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "search" + queryString(List(if(term == "") None else Some(implicitly[QueryStringBindable[String]].unbind("term", term)), if(page == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("page", page)))))
}
                        

}
                          
}
                  

// @LINE:144
package backup {

// @LINE:144
class ReverseBackupDatabase {


// @LINE:144
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/backup")
}
                        

}
                          
}
                  

// @LINE:99
// @LINE:98
// @LINE:97
package sso {

// @LINE:99
// @LINE:98
// @LINE:97
class ReverseSSOLogin {


// @LINE:97
def login(returnarg:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("returnarg", returnarg)))))
}
                        

// @LINE:98
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:99
def verifylogin(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "verifylogin")
}
                        

}
                          
}
                  

// @LINE:176
// @LINE:175
package redir {

// @LINE:176
// @LINE:175
class ReverseRedir {


// @LINE:175
def artikler(path:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "artikler/" + implicitly[PathBindable[String]].unbind("path", path))
}
                        

// @LINE:176
def nyheter(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "nyheter")
}
                        

}
                          
}
                  

// @LINE:172
// @LINE:170
// @LINE:168
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:162
// @LINE:161
// @LINE:159
// @LINE:158
// @LINE:157
package examples.controllers {

// @LINE:172
class ReverseExampleStaticAccess {


// @LINE:172
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "examples/access")
}
                        

}
                          

// @LINE:168
class ReverseExampleDatabase {


// @LINE:168
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "examples/database")
}
                        

}
                          

// @LINE:159
// @LINE:158
// @LINE:157
class ReverseExampleEbean {


// @LINE:158
def add(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "examples/ebean")
}
                        

// @LINE:157
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "examples/ebean")
}
                        

// @LINE:159
def clear(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "examples/ebean/clear")
}
                        

}
                          

// @LINE:166
// @LINE:165
// @LINE:164
class ReverseExampleCookies {


// @LINE:164
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "examples/cookies")
}
                        

// @LINE:166
// @LINE:165
def clearAllCookies(): Call = {
   () match {
// @LINE:165
case ()  =>
  import ReverseRouteContext.empty
  Call("POST", _prefix + { _defaultPrefix } + "examples/cookies/clear")
                                         
   }
}
                                                

}
                          

// @LINE:162
// @LINE:161
class ReverseExampleImageUpload {


// @LINE:162
def upload(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "examples/imageupload")
}
                        

// @LINE:161
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "examples/imageupload")
}
                        

}
                          

// @LINE:170
class ReverseExampleAngular {


// @LINE:170
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "examples/angular")
}
                        

}
                          
}
                  

// @LINE:181
// @LINE:179
// @LINE:148
// @LINE:147
package controllers {

// @LINE:181
class ReverseRestricted {


// @LINE:181
def at(restriction:String, file:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "begrenset/" + implicitly[PathBindable[String]].unbind("restriction", dynamicString(restriction)) + "/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:179
class ReverseAssets {


// @LINE:179
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:148
// @LINE:147
class ReverseUpload {


// @LINE:147
def ajaxUpload(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "api/upload")
}
                        

// @LINE:148
def ajaxUploadTo(uploadFolder:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "api/upload/" + implicitly[PathBindable[String]].unbind("uploadFolder", dynamicString(uploadFolder)))
}
                        

}
                          
}
                  

// @LINE:64
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
package article {

// @LINE:53
// @LINE:49
// @LINE:48
class ReverseArticleIn {


// @LINE:49
def save(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "artikkel/ny")
}
                        

// @LINE:53
def saveEdit(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "artikkel/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/lagreEndring")
}
                        

// @LINE:48
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "artikkel/ny")
}
                        

}
                          

// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:56
// @LINE:55
class ReverseEvent {


// @LINE:60
def updateUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/meldpaa")
}
                        

// @LINE:56
def editEvent(id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/endre")
}
                        

// @LINE:61
def removeUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/meldav")
}
                        

// @LINE:55
def viewEvent(id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:58
def saveEdit(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/lagreEndring")
}
                        

}
                          

// @LINE:64
// @LINE:63
// @LINE:51
// @LINE:50
class ReverseArticle {


// @LINE:51
def editArticle(id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "artikkel/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/endre")
}
                        

// @LINE:50
def viewArticle(id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "artikkel/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:64
def deleteComment(commentID:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "comment/delete/" + implicitly[PathBindable[String]].unbind("commentID", dynamicString(commentID)))
}
                        

// @LINE:63
def comment(articleID:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "comment/" + implicitly[PathBindable[String]].unbind("articleID", dynamicString(articleID)))
}
                        

}
                          
}
                  

// @LINE:100
package contactforuser {

// @LINE:100
class ReverseContactForUser {


// @LINE:100
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "kontaktforbruker")
}
                        

}
                          
}
                  

// @LINE:94
// @LINE:93
// @LINE:92
package gallery {

// @LINE:94
// @LINE:93
// @LINE:92
class ReverseGallery {


// @LINE:93
def uploadGalleryImage(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "api/submitImage")
}
                        

// @LINE:92
def display(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "galleri")
}
                        

// @LINE:94
def giveImageClickScore(imageId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/clickScoreImage" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("imageId", imageId)))))
}
                        

}
                          
}
                  

// @LINE:89
// @LINE:88
// @LINE:87
package calendar {

// @LINE:89
// @LINE:88
// @LINE:87
class ReverseCalendar {


// @LINE:88
def fetch(start:String, end:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/kalender/hent" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("start", start)), Some(implicitly[QueryStringBindable[String]].unbind("end", end)))))
}
                        

// @LINE:87
def display(gcal:Boolean = false): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "kalender" + queryString(List(if(gcal == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("gcal", gcal)))))
}
                        

// @LINE:89
def change(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "api/kalender/endre")
}
                        

}
                          
}
                  

// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
package quiz {

// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
class ReverseQuizController {


// @LINE:113
def putSeason(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "api/quiz/season")
}
                        

// @LINE:112
def quizSeasons(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/quiz/seasons")
}
                        

// @LINE:109
def quizTeams(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/quiz/teams")
}
                        

// @LINE:114
def deleteSeasonById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "api/quiz/season/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:110
def putTeam(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "api/quiz/team")
}
                        

// @LINE:111
def deleteTeamById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "api/quiz/team/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:108
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "quiz")
}
                        

}
                          
}
                  

// @LINE:153
// @LINE:152
package chat {

// @LINE:153
// @LINE:152
class ReverseChat {


// @LINE:152
def connectClient(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "chat")
}
                        

// @LINE:153
def socket(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "chatserver")
}
                        

}
                          
}
                  

// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
package admintools {

// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
class ReverseAdmin {


// @LINE:45
def bulkAddSingle(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "admin/api/bulkaddsingle")
}
                        

// @LINE:44
def bulkUsers(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "admin/bulkusers")
}
                        

// @LINE:40
// @LINE:39
def logout(): Call = {
   () match {
// @LINE:39
case ()  =>
  import ReverseRouteContext.empty
  Call("POST", _prefix + { _defaultPrefix } + "admin/logout")
                                         
   }
}
                                                

// @LINE:41
def allUsers(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "admin/users")
}
                        

// @LINE:43
def bulkUsersForm(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "admin/bulkusers")
}
                        

// @LINE:38
def editUser(uid:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "admin/rediger" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("uid", uid)))))
}
                        

// @LINE:42
def newUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "admin/newuser")
}
                        

// @LINE:36
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "admin")
}
                        

// @LINE:37
def login(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "admin/login")
}
                        

}
                          
}
                  

// @LINE:105
// @LINE:104
// @LINE:103
package profile {

// @LINE:105
// @LINE:104
// @LINE:103
class ReverseProfile {


// @LINE:104
def edit(username:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "profil/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/rediger")
}
                        

// @LINE:103
def index(username:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "profil/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)))
}
                        

// @LINE:105
def update(username:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "profil/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/rediger")
}
                        

}
                          
}
                  

// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:67
package bedkomdatabase {

// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:67
class ReverseBedkomdatabase {


// @LINE:75
def updateKontaktPerson(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/kontakt/ud/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:71
def deleteBedrift(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/bedrift/slett/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:70
def updateBedrift(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/bedrift/ud/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:73
def saveKontaktPerson(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/kontakt/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:74
def deleteKontaktPerson(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/kontakt/slett/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:78
def updateNote(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/notat/ud/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:77
def saveNote(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/notat/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:69
def saveBedrift(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/bedrift")
}
                        

// @LINE:79
def deleteNote(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomdatabase/notat/slett/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:67
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "bedkomdatabase")
}
                        

}
                          
}
                  

// @LINE:84
// @LINE:83
// @LINE:82
package bedpressblock {

// @LINE:84
// @LINE:83
// @LINE:82
class ReverseBedPresBlock {


// @LINE:84
def blockUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomblokkering/blokker")
}
                        

// @LINE:83
def pickUsers(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "bedkomblokkering")
}
                        

// @LINE:82
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "bedkomblokkering")
}
                        

}
                          
}
                  

// @LINE:125
package timeline {

// @LINE:125
class ReverseTimeline {


// @LINE:125
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tidslinje")
}
                        

}
                          
}
                  

// @LINE:130
// @LINE:129
// @LINE:128
package update {

// @LINE:130
// @LINE:129
// @LINE:128
class ReverseUpdate {


// @LINE:129
def utgaver(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "update/utgaver")
}
                        

// @LINE:130
def redaksjon(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "update/redaksjon")
}
                        

// @LINE:128
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "update")
}
                        

}
                          
}
                  

// @LINE:28
package strikk {

// @LINE:28
class ReverseHybridaStrikk {


// @LINE:28
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "strikk")
}
                        

}
                          
}
                  

// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
package ballot {

// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseVoteController {


// @LINE:136
def attemptVote(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "avstemning")
}
                        

// @LINE:138
def overview(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "avstemning/oversikt")
}
                        

// @LINE:139
def newBallot(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "avstemning/oversikt")
}
                        

// @LINE:137
def getChoices(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "avstemning/valg")
}
                        

// @LINE:134
// @LINE:133
def lazyRedirect(): Call = {
   () match {
// @LINE:133
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "gf")
                                         
   }
}
                                                

// @LINE:140
def getResults(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "avstemning/resultater")
}
                        

// @LINE:135
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "avstemning")
}
                        

}
                          
}
                  


// @LINE:188
// @LINE:187
// @LINE:184
// @LINE:9
// @LINE:8
// @LINE:5
package application.javascript {
import ReverseRouteContext.empty

// @LINE:188
// @LINE:187
// @LINE:184
// @LINE:9
// @LINE:8
// @LINE:5
class ReverseApplication {


// @LINE:188
def show404 : JavascriptReverseRoute = JavascriptReverseRoute(
   "application.Application.show404",
   """
      function(anything) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("anything", anything)})
      }
   """
)
                        

// @LINE:5
def untrail : JavascriptReverseRoute = JavascriptReverseRoute(
   "application.Application.untrail",
   """
      function(path) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("path", path) + "/"})
      }
   """
)
                        

// @LINE:187
def show400 : JavascriptReverseRoute = JavascriptReverseRoute(
   "application.Application.show400",
   """
      function(error) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "error400/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("error", encodeURIComponent(error))})
      }
   """
)
                        

// @LINE:8
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "application.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:9
def forside : JavascriptReverseRoute = JavascriptReverseRoute(
   "application.Application.forside",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "forside"})
      }
   """
)
                        

// @LINE:184
def showUnauthorizedAccess : JavascriptReverseRoute = JavascriptReverseRoute(
   "application.Application.showUnauthorizedAccess",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "unauthorized"})
      }
   """
)
                        

}
              
}
        

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
package staticpages.javascript {
import ReverseRouteContext.empty

// @LINE:30
class ReverseTillitsvalgte {


// @LINE:30
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.Tillitsvalgte.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tillitsvalgte"})
      }
   """
)
                        

}
              

// @LINE:31
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:16
// @LINE:13
class ReverseAbout {


// @LINE:26
def redaksjonen : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.About.redaksjonen",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "redaksjonen"})
      }
   """
)
                        

// @LINE:24
def jentekom : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.About.jentekom",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jentekom"})
      }
   """
)
                        

// @LINE:31
def vevkom : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.About.vevkom",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "vevkom"})
      }
   """
)
                        

// @LINE:25
def newStudent : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.About.newStudent",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nystudent"})
      }
   """
)
                        

// @LINE:29
def styret : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.About.styret",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "styret"})
      }
   """
)
                        

// @LINE:13
def arrkom : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.About.arrkom",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "arrkom"})
      }
   """
)
                        

// @LINE:21
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.About.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "info"})
      }
   """
)
                        

// @LINE:16
def bedkom : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.About.bedkom",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkom"})
      }
   """
)
                        

}
              

// @LINE:23
// @LINE:22
// @LINE:17
// @LINE:15
class ReverseRingen {


// @LINE:23
def about : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.Ringen.about",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "i&iktringen/om"})
      }
   """
)
                        

// @LINE:17
def ekskursjoner : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.Ringen.ekskursjoner",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ekskursjoner"})
      }
   """
)
                        

// @LINE:15
def bedriftspresentasjoner : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.Ringen.bedriftspresentasjoner",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bedriftspresentasjon"})
      }
   """
)
                        

// @LINE:22
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.Ringen.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "i&iktringen"})
      }
   """
)
                        

}
              

// @LINE:14
class ReverseBedrift {


// @LINE:14
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.Bedrift.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bedrift"})
      }
   """
)
                        

}
              

// @LINE:27
class ReverseStatutter {


// @LINE:27
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "staticpages.Statutter.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "statutter"})
      }
   """
)
                        

}
              
}
        

// @LINE:119
// @LINE:118
// @LINE:117
package rfid.javascript {
import ReverseRouteContext.empty

// @LINE:119
// @LINE:118
// @LINE:117
class ReverseRFIDReader {


// @LINE:118
def indexContinue : JavascriptReverseRoute = JavascriptReverseRoute(
   "rfid.RFIDReader.indexContinue",
   """
      function(status,number,eventId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rfid/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("status", encodeURIComponent(status)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("number", encodeURIComponent(number)) + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("eventId", eventId)])})
      }
   """
)
                        

// @LINE:117
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "rfid.RFIDReader.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rfid"})
      }
   """
)
                        

// @LINE:119
def read : JavascriptReverseRoute = JavascriptReverseRoute(
   "rfid.RFIDReader.read",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rfid"})
      }
   """
)
                        

}
              
}
        

// @LINE:10
package test.javascript {
import ReverseRouteContext.empty

// @LINE:10
class ReverseTestDatabase {


// @LINE:10
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "test.TestDatabase.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "insertqt"})
      }
   """
)
                        

}
              
}
        

// @LINE:20
// @LINE:19
// @LINE:18
package griffensorden.javascript {
import ReverseRouteContext.empty

// @LINE:20
// @LINE:19
// @LINE:18
class ReverseGriffensOrden {


// @LINE:18
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "griffensorden.GriffensOrden.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "griffensorden"})
      }
   """
)
                        

// @LINE:20
def nomination : JavascriptReverseRoute = JavascriptReverseRoute(
   "griffensorden.GriffensOrden.nomination",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "griffensorden/nominasjon"})
      }
   """
)
                        

// @LINE:19
def riddere : JavascriptReverseRoute = JavascriptReverseRoute(
   "griffensorden.GriffensOrden.riddere",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "griffensorden/riddere"})
      }
   """
)
                        

}
              
}
        

// @LINE:122
package renders.javascript {
import ReverseRouteContext.empty

// @LINE:122
class ReverseSearch {


// @LINE:122
def search : JavascriptReverseRoute = JavascriptReverseRoute(
   "renders.Search.search",
   """
      function(term,page) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search" + _qS([(term == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("term", term)), (page == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("page", page))])})
      }
   """
)
                        

}
              
}
        

// @LINE:144
package backup.javascript {
import ReverseRouteContext.empty

// @LINE:144
class ReverseBackupDatabase {


// @LINE:144
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "backup.BackupDatabase.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/backup"})
      }
   """
)
                        

}
              
}
        

// @LINE:99
// @LINE:98
// @LINE:97
package sso.javascript {
import ReverseRouteContext.empty

// @LINE:99
// @LINE:98
// @LINE:97
class ReverseSSOLogin {


// @LINE:97
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "sso.SSOLogin.login",
   """
      function(returnarg) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("returnarg", returnarg)])})
      }
   """
)
                        

// @LINE:98
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "sso.SSOLogin.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:99
def verifylogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "sso.SSOLogin.verifylogin",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "verifylogin"})
      }
   """
)
                        

}
              
}
        

// @LINE:176
// @LINE:175
package redir.javascript {
import ReverseRouteContext.empty

// @LINE:176
// @LINE:175
class ReverseRedir {


// @LINE:175
def artikler : JavascriptReverseRoute = JavascriptReverseRoute(
   "redir.Redir.artikler",
   """
      function(path) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "artikler/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("path", path)})
      }
   """
)
                        

// @LINE:176
def nyheter : JavascriptReverseRoute = JavascriptReverseRoute(
   "redir.Redir.nyheter",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nyheter"})
      }
   """
)
                        

}
              
}
        

// @LINE:172
// @LINE:170
// @LINE:168
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:162
// @LINE:161
// @LINE:159
// @LINE:158
// @LINE:157
package examples.controllers.javascript {
import ReverseRouteContext.empty

// @LINE:172
class ReverseExampleStaticAccess {


// @LINE:172
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleStaticAccess.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/access"})
      }
   """
)
                        

}
              

// @LINE:168
class ReverseExampleDatabase {


// @LINE:168
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleDatabase.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/database"})
      }
   """
)
                        

}
              

// @LINE:159
// @LINE:158
// @LINE:157
class ReverseExampleEbean {


// @LINE:158
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleEbean.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/ebean"})
      }
   """
)
                        

// @LINE:157
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleEbean.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/ebean"})
      }
   """
)
                        

// @LINE:159
def clear : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleEbean.clear",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/ebean/clear"})
      }
   """
)
                        

}
              

// @LINE:166
// @LINE:165
// @LINE:164
class ReverseExampleCookies {


// @LINE:164
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleCookies.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/cookies"})
      }
   """
)
                        

// @LINE:166
// @LINE:165
def clearAllCookies : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleCookies.clearAllCookies",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/cookies/clear"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/cookies/clear"})
      }
      }
   """
)
                        

}
              

// @LINE:162
// @LINE:161
class ReverseExampleImageUpload {


// @LINE:162
def upload : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleImageUpload.upload",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/imageupload"})
      }
   """
)
                        

// @LINE:161
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleImageUpload.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/imageupload"})
      }
   """
)
                        

}
              

// @LINE:170
class ReverseExampleAngular {


// @LINE:170
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "examples.controllers.ExampleAngular.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "examples/angular"})
      }
   """
)
                        

}
              
}
        

// @LINE:181
// @LINE:179
// @LINE:148
// @LINE:147
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:181
class ReverseRestricted {


// @LINE:181
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Restricted.at",
   """
      function(restriction,file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "begrenset/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("restriction", encodeURIComponent(restriction)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:179
class ReverseAssets {


// @LINE:179
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:148
// @LINE:147
class ReverseUpload {


// @LINE:147
def ajaxUpload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Upload.ajaxUpload",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/upload"})
      }
   """
)
                        

// @LINE:148
def ajaxUploadTo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Upload.ajaxUploadTo",
   """
      function(uploadFolder) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/upload/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("uploadFolder", encodeURIComponent(uploadFolder))})
      }
   """
)
                        

}
              
}
        

// @LINE:64
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
package article.javascript {
import ReverseRouteContext.empty

// @LINE:53
// @LINE:49
// @LINE:48
class ReverseArticleIn {


// @LINE:49
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.ArticleIn.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "artikkel/ny"})
      }
   """
)
                        

// @LINE:53
def saveEdit : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.ArticleIn.saveEdit",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "artikkel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/lagreEndring"})
      }
   """
)
                        

// @LINE:48
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.ArticleIn.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "artikkel/ny"})
      }
   """
)
                        

}
              

// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:56
// @LINE:55
class ReverseEvent {


// @LINE:60
def updateUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Event.updateUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/meldpaa"})
      }
   """
)
                        

// @LINE:56
def editEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Event.editEvent",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/endre"})
      }
   """
)
                        

// @LINE:61
def removeUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Event.removeUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/meldav"})
      }
   """
)
                        

// @LINE:55
def viewEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Event.viewEvent",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:58
def saveEdit : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Event.saveEdit",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/lagreEndring"})
      }
   """
)
                        

}
              

// @LINE:64
// @LINE:63
// @LINE:51
// @LINE:50
class ReverseArticle {


// @LINE:51
def editArticle : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Article.editArticle",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "artikkel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/endre"})
      }
   """
)
                        

// @LINE:50
def viewArticle : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Article.viewArticle",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "artikkel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:64
def deleteComment : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Article.deleteComment",
   """
      function(commentID) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/delete/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("commentID", encodeURIComponent(commentID))})
      }
   """
)
                        

// @LINE:63
def comment : JavascriptReverseRoute = JavascriptReverseRoute(
   "article.Article.comment",
   """
      function(articleID) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("articleID", encodeURIComponent(articleID))})
      }
   """
)
                        

}
              
}
        

// @LINE:100
package contactforuser.javascript {
import ReverseRouteContext.empty

// @LINE:100
class ReverseContactForUser {


// @LINE:100
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "contactforuser.ContactForUser.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "kontaktforbruker"})
      }
   """
)
                        

}
              
}
        

// @LINE:94
// @LINE:93
// @LINE:92
package gallery.javascript {
import ReverseRouteContext.empty

// @LINE:94
// @LINE:93
// @LINE:92
class ReverseGallery {


// @LINE:93
def uploadGalleryImage : JavascriptReverseRoute = JavascriptReverseRoute(
   "gallery.Gallery.uploadGalleryImage",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/submitImage"})
      }
   """
)
                        

// @LINE:92
def display : JavascriptReverseRoute = JavascriptReverseRoute(
   "gallery.Gallery.display",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "galleri"})
      }
   """
)
                        

// @LINE:94
def giveImageClickScore : JavascriptReverseRoute = JavascriptReverseRoute(
   "gallery.Gallery.giveImageClickScore",
   """
      function(imageId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/clickScoreImage" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("imageId", imageId)])})
      }
   """
)
                        

}
              
}
        

// @LINE:89
// @LINE:88
// @LINE:87
package calendar.javascript {
import ReverseRouteContext.empty

// @LINE:89
// @LINE:88
// @LINE:87
class ReverseCalendar {


// @LINE:88
def fetch : JavascriptReverseRoute = JavascriptReverseRoute(
   "calendar.Calendar.fetch",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/kalender/hent" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("start", start), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("end", end)])})
      }
   """
)
                        

// @LINE:87
def display : JavascriptReverseRoute = JavascriptReverseRoute(
   "calendar.Calendar.display",
   """
      function(gcal) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "kalender" + _qS([(gcal == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("gcal", gcal))])})
      }
   """
)
                        

// @LINE:89
def change : JavascriptReverseRoute = JavascriptReverseRoute(
   "calendar.Calendar.change",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/kalender/endre"})
      }
   """
)
                        

}
              
}
        

// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
package quiz.javascript {
import ReverseRouteContext.empty

// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
class ReverseQuizController {


// @LINE:113
def putSeason : JavascriptReverseRoute = JavascriptReverseRoute(
   "quiz.QuizController.putSeason",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/quiz/season"})
      }
   """
)
                        

// @LINE:112
def quizSeasons : JavascriptReverseRoute = JavascriptReverseRoute(
   "quiz.QuizController.quizSeasons",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/quiz/seasons"})
      }
   """
)
                        

// @LINE:109
def quizTeams : JavascriptReverseRoute = JavascriptReverseRoute(
   "quiz.QuizController.quizTeams",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/quiz/teams"})
      }
   """
)
                        

// @LINE:114
def deleteSeasonById : JavascriptReverseRoute = JavascriptReverseRoute(
   "quiz.QuizController.deleteSeasonById",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/quiz/season/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:110
def putTeam : JavascriptReverseRoute = JavascriptReverseRoute(
   "quiz.QuizController.putTeam",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/quiz/team"})
      }
   """
)
                        

// @LINE:111
def deleteTeamById : JavascriptReverseRoute = JavascriptReverseRoute(
   "quiz.QuizController.deleteTeamById",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/quiz/team/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:108
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "quiz.QuizController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz"})
      }
   """
)
                        

}
              
}
        

// @LINE:153
// @LINE:152
package chat.javascript {
import ReverseRouteContext.empty

// @LINE:153
// @LINE:152
class ReverseChat {


// @LINE:152
def connectClient : JavascriptReverseRoute = JavascriptReverseRoute(
   "chat.Chat.connectClient",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chat"})
      }
   """
)
                        

// @LINE:153
def socket : JavascriptReverseRoute = JavascriptReverseRoute(
   "chat.Chat.socket",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chatserver"})
      }
   """
)
                        

}
              
}
        

// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
package admintools.javascript {
import ReverseRouteContext.empty

// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
class ReverseAdmin {


// @LINE:45
def bulkAddSingle : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.bulkAddSingle",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/api/bulkaddsingle"})
      }
   """
)
                        

// @LINE:44
def bulkUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.bulkUsers",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/bulkusers"})
      }
   """
)
                        

// @LINE:40
// @LINE:39
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.logout",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/logout"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/logout"})
      }
      }
   """
)
                        

// @LINE:41
def allUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.allUsers",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/users"})
      }
   """
)
                        

// @LINE:43
def bulkUsersForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.bulkUsersForm",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/bulkusers"})
      }
   """
)
                        

// @LINE:38
def editUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.editUser",
   """
      function(uid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/rediger" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("uid", uid)])})
      }
   """
)
                        

// @LINE:42
def newUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.newUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/newuser"})
      }
   """
)
                        

// @LINE:36
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
      }
   """
)
                        

// @LINE:37
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "admintools.Admin.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/login"})
      }
   """
)
                        

}
              
}
        

// @LINE:105
// @LINE:104
// @LINE:103
package profile.javascript {
import ReverseRouteContext.empty

// @LINE:105
// @LINE:104
// @LINE:103
class ReverseProfile {


// @LINE:104
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "profile.Profile.edit",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profil/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username)) + "/rediger"})
      }
   """
)
                        

// @LINE:103
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "profile.Profile.index",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profil/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username))})
      }
   """
)
                        

// @LINE:105
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "profile.Profile.update",
   """
      function(username) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "profil/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username)) + "/rediger"})
      }
   """
)
                        

}
              
}
        

// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:67
package bedkomdatabase.javascript {
import ReverseRouteContext.empty

// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:67
class ReverseBedkomdatabase {


// @LINE:75
def updateKontaktPerson : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.updateKontaktPerson",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/kontakt/ud/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:71
def deleteBedrift : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.deleteBedrift",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/bedrift/slett/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:70
def updateBedrift : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.updateBedrift",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/bedrift/ud/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:73
def saveKontaktPerson : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.saveKontaktPerson",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/kontakt/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:74
def deleteKontaktPerson : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.deleteKontaktPerson",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/kontakt/slett/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:78
def updateNote : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.updateNote",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/notat/ud/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:77
def saveNote : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.saveNote",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/notat/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:69
def saveBedrift : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.saveBedrift",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/bedrift"})
      }
   """
)
                        

// @LINE:79
def deleteNote : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.deleteNote",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase/notat/slett/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:67
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedkomdatabase.Bedkomdatabase.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomdatabase"})
      }
   """
)
                        

}
              
}
        

// @LINE:84
// @LINE:83
// @LINE:82
package bedpressblock.javascript {
import ReverseRouteContext.empty

// @LINE:84
// @LINE:83
// @LINE:82
class ReverseBedPresBlock {


// @LINE:84
def blockUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedpressblock.BedPresBlock.blockUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomblokkering/blokker"})
      }
   """
)
                        

// @LINE:83
def pickUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedpressblock.BedPresBlock.pickUsers",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomblokkering"})
      }
   """
)
                        

// @LINE:82
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "bedpressblock.BedPresBlock.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bedkomblokkering"})
      }
   """
)
                        

}
              
}
        

// @LINE:125
package timeline.javascript {
import ReverseRouteContext.empty

// @LINE:125
class ReverseTimeline {


// @LINE:125
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "timeline.Timeline.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tidslinje"})
      }
   """
)
                        

}
              
}
        

// @LINE:130
// @LINE:129
// @LINE:128
package update.javascript {
import ReverseRouteContext.empty

// @LINE:130
// @LINE:129
// @LINE:128
class ReverseUpdate {


// @LINE:129
def utgaver : JavascriptReverseRoute = JavascriptReverseRoute(
   "update.Update.utgaver",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "update/utgaver"})
      }
   """
)
                        

// @LINE:130
def redaksjon : JavascriptReverseRoute = JavascriptReverseRoute(
   "update.Update.redaksjon",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "update/redaksjon"})
      }
   """
)
                        

// @LINE:128
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "update.Update.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "update"})
      }
   """
)
                        

}
              
}
        

// @LINE:28
package strikk.javascript {
import ReverseRouteContext.empty

// @LINE:28
class ReverseHybridaStrikk {


// @LINE:28
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "strikk.HybridaStrikk.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "strikk"})
      }
   """
)
                        

}
              
}
        

// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
package ballot.javascript {
import ReverseRouteContext.empty

// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseVoteController {


// @LINE:136
def attemptVote : JavascriptReverseRoute = JavascriptReverseRoute(
   "ballot.VoteController.attemptVote",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "avstemning"})
      }
   """
)
                        

// @LINE:138
def overview : JavascriptReverseRoute = JavascriptReverseRoute(
   "ballot.VoteController.overview",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "avstemning/oversikt"})
      }
   """
)
                        

// @LINE:139
def newBallot : JavascriptReverseRoute = JavascriptReverseRoute(
   "ballot.VoteController.newBallot",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "avstemning/oversikt"})
      }
   """
)
                        

// @LINE:137
def getChoices : JavascriptReverseRoute = JavascriptReverseRoute(
   "ballot.VoteController.getChoices",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "avstemning/valg"})
      }
   """
)
                        

// @LINE:134
// @LINE:133
def lazyRedirect : JavascriptReverseRoute = JavascriptReverseRoute(
   "ballot.VoteController.lazyRedirect",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "gf"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "genfors"})
      }
      }
   """
)
                        

// @LINE:140
def getResults : JavascriptReverseRoute = JavascriptReverseRoute(
   "ballot.VoteController.getResults",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "avstemning/resultater"})
      }
   """
)
                        

// @LINE:135
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "ballot.VoteController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "avstemning"})
      }
   """
)
                        

}
              
}
        


// @LINE:188
// @LINE:187
// @LINE:184
// @LINE:9
// @LINE:8
// @LINE:5
package application.ref {


// @LINE:188
// @LINE:187
// @LINE:184
// @LINE:9
// @LINE:8
// @LINE:5
class ReverseApplication {


// @LINE:188
def show404(anything:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   application.Application.show404(anything), HandlerDef(this.getClass.getClassLoader, "", "application.Application", "show404", Seq(classOf[String]), "GET", """""", _prefix + """$anything<.*>""")
)
                      

// @LINE:5
def untrail(path:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   application.Application.untrail(path), HandlerDef(this.getClass.getClassLoader, "", "application.Application", "untrail", Seq(classOf[String]), "GET", """ Strips traling slashes from urls""", _prefix + """$path<.+>/""")
)
                      

// @LINE:187
def show400(error:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   application.Application.show400(error), HandlerDef(this.getClass.getClassLoader, "", "application.Application", "show400", Seq(classOf[String]), "GET", """ Show some page describing the URL if all else fails""", _prefix + """error400/$error<[^/]+>""")
)
                      

// @LINE:8
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   application.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "application.Application", "index", Seq(), "GET", """ Standard layout accessible pages""", _prefix + """""")
)
                      

// @LINE:9
def forside(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   application.Application.forside(), HandlerDef(this.getClass.getClassLoader, "", "application.Application", "forside", Seq(), "GET", """""", _prefix + """forside""")
)
                      

// @LINE:184
def showUnauthorizedAccess(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   application.Application.showUnauthorizedAccess(), HandlerDef(this.getClass.getClassLoader, "", "application.Application", "showUnauthorizedAccess", Seq(), "GET", """FIXME: Controllers burde kanskje returnere Application.showUnauthorizedAccess() heller enn å redirecte dit?""", _prefix + """unauthorized""")
)
                      

}
                          
}
        

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
package staticpages.ref {


// @LINE:30
class ReverseTillitsvalgte {


// @LINE:30
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.Tillitsvalgte.index(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.Tillitsvalgte", "index", Seq(), "GET", """""", _prefix + """tillitsvalgte""")
)
                      

}
                          

// @LINE:31
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:16
// @LINE:13
class ReverseAbout {


// @LINE:26
def redaksjonen(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.About.redaksjonen(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "redaksjonen", Seq(), "GET", """""", _prefix + """redaksjonen""")
)
                      

// @LINE:24
def jentekom(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.About.jentekom(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "jentekom", Seq(), "GET", """""", _prefix + """jentekom""")
)
                      

// @LINE:31
def vevkom(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.About.vevkom(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "vevkom", Seq(), "GET", """""", _prefix + """vevkom""")
)
                      

// @LINE:25
def newStudent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.About.newStudent(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "newStudent", Seq(), "GET", """""", _prefix + """nystudent""")
)
                      

// @LINE:29
def styret(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.About.styret(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "styret", Seq(), "GET", """""", _prefix + """styret""")
)
                      

// @LINE:13
def arrkom(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.About.arrkom(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "arrkom", Seq(), "GET", """ STATIC INFO PAGES""", _prefix + """arrkom""")
)
                      

// @LINE:21
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.About.index(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "index", Seq(), "GET", """""", _prefix + """info""")
)
                      

// @LINE:16
def bedkom(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.About.bedkom(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "bedkom", Seq(), "GET", """""", _prefix + """bedkom""")
)
                      

}
                          

// @LINE:23
// @LINE:22
// @LINE:17
// @LINE:15
class ReverseRingen {


// @LINE:23
def about(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.Ringen.about(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.Ringen", "about", Seq(), "GET", """""", _prefix + """i&iktringen/om""")
)
                      

// @LINE:17
def ekskursjoner(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.Ringen.ekskursjoner(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.Ringen", "ekskursjoner", Seq(), "GET", """""", _prefix + """ekskursjoner""")
)
                      

// @LINE:15
def bedriftspresentasjoner(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.Ringen.bedriftspresentasjoner(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.Ringen", "bedriftspresentasjoner", Seq(), "GET", """""", _prefix + """bedriftspresentasjon""")
)
                      

// @LINE:22
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.Ringen.index(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.Ringen", "index", Seq(), "GET", """""", _prefix + """i&iktringen""")
)
                      

}
                          

// @LINE:14
class ReverseBedrift {


// @LINE:14
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.Bedrift.index(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.Bedrift", "index", Seq(), "GET", """""", _prefix + """bedrift""")
)
                      

}
                          

// @LINE:27
class ReverseStatutter {


// @LINE:27
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   staticpages.Statutter.index(), HandlerDef(this.getClass.getClassLoader, "", "staticpages.Statutter", "index", Seq(), "GET", """""", _prefix + """statutter""")
)
                      

}
                          
}
        

// @LINE:119
// @LINE:118
// @LINE:117
package rfid.ref {


// @LINE:119
// @LINE:118
// @LINE:117
class ReverseRFIDReader {


// @LINE:118
def indexContinue(status:String, number:String, eventId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   rfid.RFIDReader.indexContinue(status, number, eventId), HandlerDef(this.getClass.getClassLoader, "", "rfid.RFIDReader", "indexContinue", Seq(classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """rfid/$status<[^/]+>/$number<[^/]+>""")
)
                      

// @LINE:117
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   rfid.RFIDReader.index(), HandlerDef(this.getClass.getClassLoader, "", "rfid.RFIDReader", "index", Seq(), "GET", """ # RFID""", _prefix + """rfid""")
)
                      

// @LINE:119
def read(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   rfid.RFIDReader.read(), HandlerDef(this.getClass.getClassLoader, "", "rfid.RFIDReader", "read", Seq(), "POST", """""", _prefix + """rfid""")
)
                      

}
                          
}
        

// @LINE:10
package test.ref {


// @LINE:10
class ReverseTestDatabase {


// @LINE:10
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   test.TestDatabase.index(), HandlerDef(this.getClass.getClassLoader, "", "test.TestDatabase", "index", Seq(), "GET", """""", _prefix + """insertqt""")
)
                      

}
                          
}
        

// @LINE:20
// @LINE:19
// @LINE:18
package griffensorden.ref {


// @LINE:20
// @LINE:19
// @LINE:18
class ReverseGriffensOrden {


// @LINE:18
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   griffensorden.GriffensOrden.index(), HandlerDef(this.getClass.getClassLoader, "", "griffensorden.GriffensOrden", "index", Seq(), "GET", """""", _prefix + """griffensorden""")
)
                      

// @LINE:20
def nomination(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   griffensorden.GriffensOrden.nomination(), HandlerDef(this.getClass.getClassLoader, "", "griffensorden.GriffensOrden", "nomination", Seq(), "GET", """""", _prefix + """griffensorden/nominasjon""")
)
                      

// @LINE:19
def riddere(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   griffensorden.GriffensOrden.riddere(), HandlerDef(this.getClass.getClassLoader, "", "griffensorden.GriffensOrden", "riddere", Seq(), "GET", """""", _prefix + """griffensorden/riddere""")
)
                      

}
                          
}
        

// @LINE:122
package renders.ref {


// @LINE:122
class ReverseSearch {


// @LINE:122
def search(term:String, page:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   renders.Search.search(term, page), HandlerDef(this.getClass.getClassLoader, "", "renders.Search", "search", Seq(classOf[String], classOf[Int]), "GET", """ # Search""", _prefix + """search""")
)
                      

}
                          
}
        

// @LINE:144
package backup.ref {


// @LINE:144
class ReverseBackupDatabase {


// @LINE:144
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   backup.BackupDatabase.index(), HandlerDef(this.getClass.getClassLoader, "", "backup.BackupDatabase", "index", Seq(), "GET", """ API
 # Backup database""", _prefix + """api/backup""")
)
                      

}
                          
}
        

// @LINE:99
// @LINE:98
// @LINE:97
package sso.ref {


// @LINE:99
// @LINE:98
// @LINE:97
class ReverseSSOLogin {


// @LINE:97
def login(returnarg:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   sso.SSOLogin.login(returnarg), HandlerDef(this.getClass.getClassLoader, "", "sso.SSOLogin", "login", Seq(classOf[String]), "GET", """ # Login""", _prefix + """login""")
)
                      

// @LINE:98
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   sso.SSOLogin.logout(), HandlerDef(this.getClass.getClassLoader, "", "sso.SSOLogin", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:99
def verifylogin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   sso.SSOLogin.verifylogin(), HandlerDef(this.getClass.getClassLoader, "", "sso.SSOLogin", "verifylogin", Seq(), "GET", """""", _prefix + """verifylogin""")
)
                      

}
                          
}
        

// @LINE:176
// @LINE:175
package redir.ref {


// @LINE:176
// @LINE:175
class ReverseRedir {


// @LINE:175
def artikler(path:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   redir.Redir.artikler(path), HandlerDef(this.getClass.getClassLoader, "", "redir.Redir", "artikler", Seq(classOf[String]), "GET", """ REDIRECT OLD""", _prefix + """artikler/$path<.+>""")
)
                      

// @LINE:176
def nyheter(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   redir.Redir.nyheter(), HandlerDef(this.getClass.getClassLoader, "", "redir.Redir", "nyheter", Seq(), "GET", """""", _prefix + """nyheter""")
)
                      

}
                          
}
        

// @LINE:172
// @LINE:170
// @LINE:168
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:162
// @LINE:161
// @LINE:159
// @LINE:158
// @LINE:157
package examples.controllers.ref {


// @LINE:172
class ReverseExampleStaticAccess {


// @LINE:172
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleStaticAccess.index(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleStaticAccess", "index", Seq(), "GET", """ # Limited Access""", _prefix + """examples/access""")
)
                      

}
                          

// @LINE:168
class ReverseExampleDatabase {


// @LINE:168
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleDatabase.index(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleDatabase", "index", Seq(), "GET", """ # Database""", _prefix + """examples/database""")
)
                      

}
                          

// @LINE:159
// @LINE:158
// @LINE:157
class ReverseExampleEbean {


// @LINE:158
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleEbean.add(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleEbean", "add", Seq(), "POST", """""", _prefix + """examples/ebean""")
)
                      

// @LINE:157
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleEbean.index(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleEbean", "index", Seq(), "GET", """ EXAMPLES
 # Ebean""", _prefix + """examples/ebean""")
)
                      

// @LINE:159
def clear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleEbean.clear(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleEbean", "clear", Seq(), "POST", """""", _prefix + """examples/ebean/clear""")
)
                      

}
                          

// @LINE:166
// @LINE:165
// @LINE:164
class ReverseExampleCookies {


// @LINE:164
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleCookies.index(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleCookies", "index", Seq(), "GET", """ # Cookies""", _prefix + """examples/cookies""")
)
                      

// @LINE:165
def clearAllCookies(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleCookies.clearAllCookies(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleCookies", "clearAllCookies", Seq(), "POST", """""", _prefix + """examples/cookies/clear""")
)
                      

}
                          

// @LINE:162
// @LINE:161
class ReverseExampleImageUpload {


// @LINE:162
def upload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleImageUpload.upload(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleImageUpload", "upload", Seq(), "POST", """""", _prefix + """examples/imageupload""")
)
                      

// @LINE:161
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleImageUpload.index(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleImageUpload", "index", Seq(), "GET", """ # ImageUpload""", _prefix + """examples/imageupload""")
)
                      

}
                          

// @LINE:170
class ReverseExampleAngular {


// @LINE:170
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   examples.controllers.ExampleAngular.index(), HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleAngular", "index", Seq(), "GET", """ # AngularJS""", _prefix + """examples/angular""")
)
                      

}
                          
}
        

// @LINE:181
// @LINE:179
// @LINE:148
// @LINE:147
package controllers.ref {


// @LINE:181
class ReverseRestricted {


// @LINE:181
def at(restriction:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Restricted.at(restriction, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Restricted", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources with restricted access from the /restricted folder to the /begrenset URL path""", _prefix + """begrenset/$restriction<[^/]+>/$file<.+>""")
)
                      

}
                          

// @LINE:179
class ReverseAssets {


// @LINE:179
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:148
// @LINE:147
class ReverseUpload {


// @LINE:147
def ajaxUpload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Upload.ajaxUpload(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Upload", "ajaxUpload", Seq(), "POST", """ # Upload files""", _prefix + """api/upload""")
)
                      

// @LINE:148
def ajaxUploadTo(uploadFolder:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Upload.ajaxUploadTo(uploadFolder), HandlerDef(this.getClass.getClassLoader, "", "controllers.Upload", "ajaxUploadTo", Seq(classOf[String]), "POST", """""", _prefix + """api/upload/$uploadFolder<[^/]+>""")
)
                      

}
                          
}
        

// @LINE:64
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
package article.ref {


// @LINE:53
// @LINE:49
// @LINE:48
class ReverseArticleIn {


// @LINE:49
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.ArticleIn.save(), HandlerDef(this.getClass.getClassLoader, "", "article.ArticleIn", "save", Seq(), "POST", """""", _prefix + """artikkel/ny""")
)
                      

// @LINE:53
def saveEdit(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.ArticleIn.saveEdit(id), HandlerDef(this.getClass.getClassLoader, "", "article.ArticleIn", "saveEdit", Seq(classOf[String]), "POST", """FIXME: Tillater vi stor bokstav i url-er?""", _prefix + """artikkel/$id<[^/]+>/lagreEndring""")
)
                      

// @LINE:48
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.ArticleIn.index(), HandlerDef(this.getClass.getClassLoader, "", "article.ArticleIn", "index", Seq(), "GET", """ # Article and events""", _prefix + """artikkel/ny""")
)
                      

}
                          

// @LINE:61
// @LINE:60
// @LINE:58
// @LINE:56
// @LINE:55
class ReverseEvent {


// @LINE:60
def updateUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Event.updateUser(), HandlerDef(this.getClass.getClassLoader, "", "article.Event", "updateUser", Seq(), "POST", """ # Bruker current login cookie, og en eventId i POST""", _prefix + """event/meldpaa""")
)
                      

// @LINE:56
def editEvent(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Event.editEvent(id), HandlerDef(this.getClass.getClassLoader, "", "article.Event", "editEvent", Seq(classOf[String]), "GET", """""", _prefix + """event/$id<[^/]+>/endre""")
)
                      

// @LINE:61
def removeUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Event.removeUser(), HandlerDef(this.getClass.getClassLoader, "", "article.Event", "removeUser", Seq(), "POST", """""", _prefix + """event/meldav""")
)
                      

// @LINE:55
def viewEvent(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Event.viewEvent(id), HandlerDef(this.getClass.getClassLoader, "", "article.Event", "viewEvent", Seq(classOf[String]), "GET", """""", _prefix + """event/$id<[^/]+>""")
)
                      

// @LINE:58
def saveEdit(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Event.saveEdit(id), HandlerDef(this.getClass.getClassLoader, "", "article.Event", "saveEdit", Seq(classOf[String]), "POST", """FIXME: Tillater vi stor bokstav i url-er?""", _prefix + """event/$id<[^/]+>/lagreEndring""")
)
                      

}
                          

// @LINE:64
// @LINE:63
// @LINE:51
// @LINE:50
class ReverseArticle {


// @LINE:51
def editArticle(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Article.editArticle(id), HandlerDef(this.getClass.getClassLoader, "", "article.Article", "editArticle", Seq(classOf[String]), "GET", """""", _prefix + """artikkel/$id<[^/]+>/endre""")
)
                      

// @LINE:50
def viewArticle(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Article.viewArticle(id), HandlerDef(this.getClass.getClassLoader, "", "article.Article", "viewArticle", Seq(classOf[String]), "GET", """""", _prefix + """artikkel/$id<[^/]+>""")
)
                      

// @LINE:64
def deleteComment(commentID:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Article.deleteComment(commentID), HandlerDef(this.getClass.getClassLoader, "", "article.Article", "deleteComment", Seq(classOf[String]), "POST", """""", _prefix + """comment/delete/$commentID<[^/]+>""")
)
                      

// @LINE:63
def comment(articleID:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   article.Article.comment(articleID), HandlerDef(this.getClass.getClassLoader, "", "article.Article", "comment", Seq(classOf[String]), "POST", """""", _prefix + """comment/$articleID<[^/]+>""")
)
                      

}
                          
}
        

// @LINE:100
package contactforuser.ref {


// @LINE:100
class ReverseContactForUser {


// @LINE:100
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   contactforuser.ContactForUser.index(), HandlerDef(this.getClass.getClassLoader, "", "contactforuser.ContactForUser", "index", Seq(), "GET", """""", _prefix + """kontaktforbruker""")
)
                      

}
                          
}
        

// @LINE:94
// @LINE:93
// @LINE:92
package gallery.ref {


// @LINE:94
// @LINE:93
// @LINE:92
class ReverseGallery {


// @LINE:93
def uploadGalleryImage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   gallery.Gallery.uploadGalleryImage(), HandlerDef(this.getClass.getClassLoader, "", "gallery.Gallery", "uploadGalleryImage", Seq(), "POST", """""", _prefix + """api/submitImage""")
)
                      

// @LINE:92
def display(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   gallery.Gallery.display(), HandlerDef(this.getClass.getClassLoader, "", "gallery.Gallery", "display", Seq(), "GET", """ # Gallery""", _prefix + """galleri""")
)
                      

// @LINE:94
def giveImageClickScore(imageId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   gallery.Gallery.giveImageClickScore(imageId), HandlerDef(this.getClass.getClassLoader, "", "gallery.Gallery", "giveImageClickScore", Seq(classOf[Long]), "GET", """""", _prefix + """api/clickScoreImage""")
)
                      

}
                          
}
        

// @LINE:89
// @LINE:88
// @LINE:87
package calendar.ref {


// @LINE:89
// @LINE:88
// @LINE:87
class ReverseCalendar {


// @LINE:88
def fetch(start:String, end:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   calendar.Calendar.fetch(start, end), HandlerDef(this.getClass.getClassLoader, "", "calendar.Calendar", "fetch", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """api/kalender/hent""")
)
                      

// @LINE:87
def display(gcal:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   calendar.Calendar.display(gcal), HandlerDef(this.getClass.getClassLoader, "", "calendar.Calendar", "display", Seq(classOf[Boolean]), "GET", """ # Calendar""", _prefix + """kalender""")
)
                      

// @LINE:89
def change(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   calendar.Calendar.change(), HandlerDef(this.getClass.getClassLoader, "", "calendar.Calendar", "change", Seq(), "POST", """""", _prefix + """api/kalender/endre""")
)
                      

}
                          
}
        

// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
package quiz.ref {


// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
class ReverseQuizController {


// @LINE:113
def putSeason(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   quiz.QuizController.putSeason(), HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "putSeason", Seq(), "PUT", """""", _prefix + """api/quiz/season""")
)
                      

// @LINE:112
def quizSeasons(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   quiz.QuizController.quizSeasons(), HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "quizSeasons", Seq(), "GET", """""", _prefix + """api/quiz/seasons""")
)
                      

// @LINE:109
def quizTeams(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   quiz.QuizController.quizTeams(), HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "quizTeams", Seq(), "GET", """""", _prefix + """api/quiz/teams""")
)
                      

// @LINE:114
def deleteSeasonById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   quiz.QuizController.deleteSeasonById(id), HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "deleteSeasonById", Seq(classOf[Long]), "DELETE", """""", _prefix + """api/quiz/season/$id<[^/]+>""")
)
                      

// @LINE:110
def putTeam(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   quiz.QuizController.putTeam(), HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "putTeam", Seq(), "PUT", """""", _prefix + """api/quiz/team""")
)
                      

// @LINE:111
def deleteTeamById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   quiz.QuizController.deleteTeamById(id), HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "deleteTeamById", Seq(classOf[Long]), "DELETE", """""", _prefix + """api/quiz/team/$id<[^/]+>""")
)
                      

// @LINE:108
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   quiz.QuizController.index(), HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "index", Seq(), "GET", """ # Quiz""", _prefix + """quiz""")
)
                      

}
                          
}
        

// @LINE:153
// @LINE:152
package chat.ref {


// @LINE:153
// @LINE:152
class ReverseChat {


// @LINE:152
def connectClient(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   chat.Chat.connectClient(), HandlerDef(this.getClass.getClassLoader, "", "chat.Chat", "connectClient", Seq(), "GET", """ TEST
 # Chat""", _prefix + """chat""")
)
                      

// @LINE:153
def socket(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   chat.Chat.socket(), HandlerDef(this.getClass.getClassLoader, "", "chat.Chat", "socket", Seq(), "GET", """""", _prefix + """chatserver""")
)
                      

}
                          
}
        

// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
package admintools.ref {


// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
class ReverseAdmin {


// @LINE:45
def bulkAddSingle(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.bulkAddSingle(), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "bulkAddSingle", Seq(), "GET", """""", _prefix + """admin/api/bulkaddsingle""")
)
                      

// @LINE:44
def bulkUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.bulkUsers(), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "bulkUsers", Seq(), "POST", """""", _prefix + """admin/bulkusers""")
)
                      

// @LINE:39
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.logout(), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "logout", Seq(), "POST", """""", _prefix + """admin/logout""")
)
                      

// @LINE:41
def allUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.allUsers(), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "allUsers", Seq(), "GET", """""", _prefix + """admin/users""")
)
                      

// @LINE:43
def bulkUsersForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.bulkUsersForm(), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "bulkUsersForm", Seq(), "GET", """""", _prefix + """admin/bulkusers""")
)
                      

// @LINE:38
def editUser(uid:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.editUser(uid), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "editUser", Seq(classOf[String]), "POST", """""", _prefix + """admin/rediger""")
)
                      

// @LINE:42
def newUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.newUser(), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "newUser", Seq(), "POST", """""", _prefix + """admin/newuser""")
)
                      

// @LINE:36
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.index(), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "index", Seq(), "GET", """ # Admin""", _prefix + """admin""")
)
                      

// @LINE:37
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   admintools.Admin.login(), HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "login", Seq(), "POST", """""", _prefix + """admin/login""")
)
                      

}
                          
}
        

// @LINE:105
// @LINE:104
// @LINE:103
package profile.ref {


// @LINE:105
// @LINE:104
// @LINE:103
class ReverseProfile {


// @LINE:104
def edit(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   profile.Profile.edit(username), HandlerDef(this.getClass.getClassLoader, "", "profile.Profile", "edit", Seq(classOf[String]), "GET", """""", _prefix + """profil/$username<[^/]+>/rediger""")
)
                      

// @LINE:103
def index(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   profile.Profile.index(username), HandlerDef(this.getClass.getClassLoader, "", "profile.Profile", "index", Seq(classOf[String]), "GET", """ # Profile""", _prefix + """profil/$username<[^/]+>""")
)
                      

// @LINE:105
def update(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   profile.Profile.update(username), HandlerDef(this.getClass.getClassLoader, "", "profile.Profile", "update", Seq(classOf[String]), "POST", """""", _prefix + """profil/$username<[^/]+>/rediger""")
)
                      

}
                          
}
        

// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:67
package bedkomdatabase.ref {


// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:67
class ReverseBedkomdatabase {


// @LINE:75
def updateKontaktPerson(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.updateKontaktPerson(id), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "updateKontaktPerson", Seq(classOf[String]), "POST", """""", _prefix + """bedkomdatabase/kontakt/ud/$id<[^/]+>""")
)
                      

// @LINE:71
def deleteBedrift(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.deleteBedrift(id), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "deleteBedrift", Seq(classOf[String]), "POST", """""", _prefix + """bedkomdatabase/bedrift/slett/$id<[^/]+>""")
)
                      

// @LINE:70
def updateBedrift(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.updateBedrift(id), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "updateBedrift", Seq(classOf[String]), "POST", """""", _prefix + """bedkomdatabase/bedrift/ud/$id<[^/]+>""")
)
                      

// @LINE:73
def saveKontaktPerson(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.saveKontaktPerson(id), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "saveKontaktPerson", Seq(classOf[String]), "POST", """""", _prefix + """bedkomdatabase/kontakt/$id<[^/]+>""")
)
                      

// @LINE:74
def deleteKontaktPerson(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.deleteKontaktPerson(id), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "deleteKontaktPerson", Seq(classOf[String]), "POST", """""", _prefix + """bedkomdatabase/kontakt/slett/$id<[^/]+>""")
)
                      

// @LINE:78
def updateNote(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.updateNote(id), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "updateNote", Seq(classOf[String]), "POST", """""", _prefix + """bedkomdatabase/notat/ud/$id<[^/]+>""")
)
                      

// @LINE:77
def saveNote(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.saveNote(id), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "saveNote", Seq(classOf[String]), "POST", """""", _prefix + """bedkomdatabase/notat/$id<[^/]+>""")
)
                      

// @LINE:69
def saveBedrift(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.saveBedrift(), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "saveBedrift", Seq(), "POST", """""", _prefix + """bedkomdatabase/bedrift""")
)
                      

// @LINE:79
def deleteNote(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.deleteNote(id), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "deleteNote", Seq(classOf[String]), "POST", """""", _prefix + """bedkomdatabase/notat/slett/$id<[^/]+>""")
)
                      

// @LINE:67
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedkomdatabase.Bedkomdatabase.index(), HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "index", Seq(), "GET", """ # Bedkom-database""", _prefix + """bedkomdatabase""")
)
                      

}
                          
}
        

// @LINE:84
// @LINE:83
// @LINE:82
package bedpressblock.ref {


// @LINE:84
// @LINE:83
// @LINE:82
class ReverseBedPresBlock {


// @LINE:84
def blockUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedpressblock.BedPresBlock.blockUser(), HandlerDef(this.getClass.getClassLoader, "", "bedpressblock.BedPresBlock", "blockUser", Seq(), "POST", """""", _prefix + """bedkomblokkering/blokker""")
)
                      

// @LINE:83
def pickUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedpressblock.BedPresBlock.pickUsers(), HandlerDef(this.getClass.getClassLoader, "", "bedpressblock.BedPresBlock", "pickUsers", Seq(), "POST", """""", _prefix + """bedkomblokkering""")
)
                      

// @LINE:82
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bedpressblock.BedPresBlock.index(), HandlerDef(this.getClass.getClassLoader, "", "bedpressblock.BedPresBlock", "index", Seq(), "GET", """ # Bedkom Blocking""", _prefix + """bedkomblokkering""")
)
                      

}
                          
}
        

// @LINE:125
package timeline.ref {


// @LINE:125
class ReverseTimeline {


// @LINE:125
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   timeline.Timeline.index(), HandlerDef(this.getClass.getClassLoader, "", "timeline.Timeline", "index", Seq(), "GET", """ # Timeline""", _prefix + """tidslinje""")
)
                      

}
                          
}
        

// @LINE:130
// @LINE:129
// @LINE:128
package update.ref {


// @LINE:130
// @LINE:129
// @LINE:128
class ReverseUpdate {


// @LINE:129
def utgaver(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   update.Update.utgaver(), HandlerDef(this.getClass.getClassLoader, "", "update.Update", "utgaver", Seq(), "GET", """""", _prefix + """update/utgaver""")
)
                      

// @LINE:130
def redaksjon(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   update.Update.redaksjon(), HandlerDef(this.getClass.getClassLoader, "", "update.Update", "redaksjon", Seq(), "GET", """""", _prefix + """update/redaksjon""")
)
                      

// @LINE:128
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   update.Update.index(), HandlerDef(this.getClass.getClassLoader, "", "update.Update", "index", Seq(), "GET", """ # Update""", _prefix + """update""")
)
                      

}
                          
}
        

// @LINE:28
package strikk.ref {


// @LINE:28
class ReverseHybridaStrikk {


// @LINE:28
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   strikk.HybridaStrikk.index(), HandlerDef(this.getClass.getClassLoader, "", "strikk.HybridaStrikk", "index", Seq(), "GET", """""", _prefix + """strikk""")
)
                      

}
                          
}
        

// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
package ballot.ref {


// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseVoteController {


// @LINE:136
def attemptVote(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   ballot.VoteController.attemptVote(), HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "attemptVote", Seq(), "POST", """""", _prefix + """avstemning""")
)
                      

// @LINE:138
def overview(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   ballot.VoteController.overview(), HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "overview", Seq(), "GET", """""", _prefix + """avstemning/oversikt""")
)
                      

// @LINE:139
def newBallot(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   ballot.VoteController.newBallot(), HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "newBallot", Seq(), "POST", """""", _prefix + """avstemning/oversikt""")
)
                      

// @LINE:137
def getChoices(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   ballot.VoteController.getChoices(), HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "getChoices", Seq(), "GET", """""", _prefix + """avstemning/valg""")
)
                      

// @LINE:133
def lazyRedirect(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   ballot.VoteController.lazyRedirect(), HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "lazyRedirect", Seq(), "GET", """ # Voting""", _prefix + """gf""")
)
                      

// @LINE:140
def getResults(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   ballot.VoteController.getResults(), HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "getResults", Seq(), "GET", """""", _prefix + """avstemning/resultater""")
)
                      

// @LINE:135
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   ballot.VoteController.index(), HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "index", Seq(), "GET", """""", _prefix + """avstemning""")
)
                      

}
                          
}
        
    