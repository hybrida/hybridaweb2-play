// @SOURCE:C:/Users/Bendik/hybridaweb2-play/conf/routes
// @HASH:d0246b3de7f4152330da6028174b011e5844c533
// @DATE:Tue Apr 19 17:37:41 CEST 2016


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:5
private[this] lazy val application_Application_untrail0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("path", """.+""",false),StaticPart("/"))))
private[this] lazy val application_Application_untrail0_invoker = createInvoker(
application.Application.untrail(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "application.Application", "untrail", Seq(classOf[String]),"GET", """ Strips traling slashes from urls""", Routes.prefix + """$path<.+>/"""))
        

// @LINE:8
private[this] lazy val application_Application_index1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val application_Application_index1_invoker = createInvoker(
application.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "application.Application", "index", Nil,"GET", """ Standard layout accessible pages""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val application_Application_forside2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("forside"))))
private[this] lazy val application_Application_forside2_invoker = createInvoker(
application.Application.forside(),
HandlerDef(this.getClass.getClassLoader, "", "application.Application", "forside", Nil,"GET", """""", Routes.prefix + """forside"""))
        

// @LINE:10
private[this] lazy val test_TestDatabase_index3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("insertqt"))))
private[this] lazy val test_TestDatabase_index3_invoker = createInvoker(
test.TestDatabase.index(),
HandlerDef(this.getClass.getClassLoader, "", "test.TestDatabase", "index", Nil,"GET", """""", Routes.prefix + """insertqt"""))
        

// @LINE:13
private[this] lazy val staticpages_About_arrkom4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arrkom"))))
private[this] lazy val staticpages_About_arrkom4_invoker = createInvoker(
staticpages.About.arrkom(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "arrkom", Nil,"GET", """ STATIC INFO PAGES""", Routes.prefix + """arrkom"""))
        

// @LINE:14
private[this] lazy val staticpages_Bedrift_index5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedrift"))))
private[this] lazy val staticpages_Bedrift_index5_invoker = createInvoker(
staticpages.Bedrift.index(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.Bedrift", "index", Nil,"GET", """""", Routes.prefix + """bedrift"""))
        

// @LINE:15
private[this] lazy val staticpages_Ringen_bedriftspresentasjoner6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedriftspresentasjon"))))
private[this] lazy val staticpages_Ringen_bedriftspresentasjoner6_invoker = createInvoker(
staticpages.Ringen.bedriftspresentasjoner(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.Ringen", "bedriftspresentasjoner", Nil,"GET", """""", Routes.prefix + """bedriftspresentasjon"""))
        

// @LINE:16
private[this] lazy val staticpages_About_bedkom7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkom"))))
private[this] lazy val staticpages_About_bedkom7_invoker = createInvoker(
staticpages.About.bedkom(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "bedkom", Nil,"GET", """""", Routes.prefix + """bedkom"""))
        

// @LINE:17
private[this] lazy val staticpages_Ringen_ekskursjoner8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ekskursjoner"))))
private[this] lazy val staticpages_Ringen_ekskursjoner8_invoker = createInvoker(
staticpages.Ringen.ekskursjoner(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.Ringen", "ekskursjoner", Nil,"GET", """""", Routes.prefix + """ekskursjoner"""))
        

// @LINE:18
private[this] lazy val griffensorden_GriffensOrden_index9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("griffensorden"))))
private[this] lazy val griffensorden_GriffensOrden_index9_invoker = createInvoker(
griffensorden.GriffensOrden.index(),
HandlerDef(this.getClass.getClassLoader, "", "griffensorden.GriffensOrden", "index", Nil,"GET", """""", Routes.prefix + """griffensorden"""))
        

// @LINE:19
private[this] lazy val griffensorden_GriffensOrden_riddere10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("griffensorden/riddere"))))
private[this] lazy val griffensorden_GriffensOrden_riddere10_invoker = createInvoker(
griffensorden.GriffensOrden.riddere(),
HandlerDef(this.getClass.getClassLoader, "", "griffensorden.GriffensOrden", "riddere", Nil,"GET", """""", Routes.prefix + """griffensorden/riddere"""))
        

// @LINE:20
private[this] lazy val griffensorden_GriffensOrden_nomination11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("griffensorden/nominasjon"))))
private[this] lazy val griffensorden_GriffensOrden_nomination11_invoker = createInvoker(
griffensorden.GriffensOrden.nomination(),
HandlerDef(this.getClass.getClassLoader, "", "griffensorden.GriffensOrden", "nomination", Nil,"GET", """""", Routes.prefix + """griffensorden/nominasjon"""))
        

// @LINE:21
private[this] lazy val staticpages_About_index12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("info"))))
private[this] lazy val staticpages_About_index12_invoker = createInvoker(
staticpages.About.index(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "index", Nil,"GET", """""", Routes.prefix + """info"""))
        

// @LINE:22
private[this] lazy val staticpages_Ringen_index13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("i&iktringen"))))
private[this] lazy val staticpages_Ringen_index13_invoker = createInvoker(
staticpages.Ringen.index(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.Ringen", "index", Nil,"GET", """""", Routes.prefix + """i&iktringen"""))
        

// @LINE:23
private[this] lazy val staticpages_Ringen_about14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("i&iktringen/om"))))
private[this] lazy val staticpages_Ringen_about14_invoker = createInvoker(
staticpages.Ringen.about(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.Ringen", "about", Nil,"GET", """""", Routes.prefix + """i&iktringen/om"""))
        

// @LINE:24
private[this] lazy val staticpages_About_jentekom15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jentekom"))))
private[this] lazy val staticpages_About_jentekom15_invoker = createInvoker(
staticpages.About.jentekom(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "jentekom", Nil,"GET", """""", Routes.prefix + """jentekom"""))
        

// @LINE:25
private[this] lazy val staticpages_About_newStudent16_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nystudent"))))
private[this] lazy val staticpages_About_newStudent16_invoker = createInvoker(
staticpages.About.newStudent(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "newStudent", Nil,"GET", """""", Routes.prefix + """nystudent"""))
        

// @LINE:26
private[this] lazy val staticpages_About_redaksjonen17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("redaksjonen"))))
private[this] lazy val staticpages_About_redaksjonen17_invoker = createInvoker(
staticpages.About.redaksjonen(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "redaksjonen", Nil,"GET", """""", Routes.prefix + """redaksjonen"""))
        

// @LINE:27
private[this] lazy val staticpages_Statutter_index18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("statutter"))))
private[this] lazy val staticpages_Statutter_index18_invoker = createInvoker(
staticpages.Statutter.index(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.Statutter", "index", Nil,"GET", """""", Routes.prefix + """statutter"""))
        

// @LINE:28
private[this] lazy val strikk_HybridaStrikk_index19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("strikk"))))
private[this] lazy val strikk_HybridaStrikk_index19_invoker = createInvoker(
strikk.HybridaStrikk.index(),
HandlerDef(this.getClass.getClassLoader, "", "strikk.HybridaStrikk", "index", Nil,"GET", """""", Routes.prefix + """strikk"""))
        

// @LINE:29
private[this] lazy val staticpages_About_styret20_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("styret"))))
private[this] lazy val staticpages_About_styret20_invoker = createInvoker(
staticpages.About.styret(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "styret", Nil,"GET", """""", Routes.prefix + """styret"""))
        

// @LINE:30
private[this] lazy val staticpages_Tillitsvalgte_index21_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tillitsvalgte"))))
private[this] lazy val staticpages_Tillitsvalgte_index21_invoker = createInvoker(
staticpages.Tillitsvalgte.index(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.Tillitsvalgte", "index", Nil,"GET", """""", Routes.prefix + """tillitsvalgte"""))
        

// @LINE:31
private[this] lazy val staticpages_About_vevkom22_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("vevkom"))))
private[this] lazy val staticpages_About_vevkom22_invoker = createInvoker(
staticpages.About.vevkom(),
HandlerDef(this.getClass.getClassLoader, "", "staticpages.About", "vevkom", Nil,"GET", """""", Routes.prefix + """vevkom"""))
        

// @LINE:36
private[this] lazy val admintools_Admin_index23_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin"))))
private[this] lazy val admintools_Admin_index23_invoker = createInvoker(
admintools.Admin.index(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "index", Nil,"GET", """ # Admin""", Routes.prefix + """admin"""))
        

// @LINE:37
private[this] lazy val admintools_Admin_login24_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/login"))))
private[this] lazy val admintools_Admin_login24_invoker = createInvoker(
admintools.Admin.login(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "login", Nil,"POST", """""", Routes.prefix + """admin/login"""))
        

// @LINE:38
private[this] lazy val admintools_Admin_editUser25_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/rediger"))))
private[this] lazy val admintools_Admin_editUser25_invoker = createInvoker(
admintools.Admin.editUser(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "editUser", Seq(classOf[String]),"POST", """""", Routes.prefix + """admin/rediger"""))
        

// @LINE:39
private[this] lazy val admintools_Admin_logout26_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/logout"))))
private[this] lazy val admintools_Admin_logout26_invoker = createInvoker(
admintools.Admin.logout(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "logout", Nil,"POST", """""", Routes.prefix + """admin/logout"""))
        

// @LINE:40
private[this] lazy val admintools_Admin_logout27_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/logout"))))
private[this] lazy val admintools_Admin_logout27_invoker = createInvoker(
admintools.Admin.logout(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "logout", Nil,"GET", """""", Routes.prefix + """admin/logout"""))
        

// @LINE:41
private[this] lazy val admintools_Admin_allUsers28_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/users"))))
private[this] lazy val admintools_Admin_allUsers28_invoker = createInvoker(
admintools.Admin.allUsers(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "allUsers", Nil,"GET", """""", Routes.prefix + """admin/users"""))
        

// @LINE:42
private[this] lazy val admintools_Admin_newUser29_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/newuser"))))
private[this] lazy val admintools_Admin_newUser29_invoker = createInvoker(
admintools.Admin.newUser(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "newUser", Nil,"POST", """""", Routes.prefix + """admin/newuser"""))
        

// @LINE:43
private[this] lazy val admintools_Admin_bulkUsersForm30_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/bulkusers"))))
private[this] lazy val admintools_Admin_bulkUsersForm30_invoker = createInvoker(
admintools.Admin.bulkUsersForm(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "bulkUsersForm", Nil,"GET", """""", Routes.prefix + """admin/bulkusers"""))
        

// @LINE:44
private[this] lazy val admintools_Admin_bulkUsers31_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/bulkusers"))))
private[this] lazy val admintools_Admin_bulkUsers31_invoker = createInvoker(
admintools.Admin.bulkUsers(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "bulkUsers", Nil,"POST", """""", Routes.prefix + """admin/bulkusers"""))
        

// @LINE:45
private[this] lazy val admintools_Admin_bulkAddSingle32_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/api/bulkaddsingle"))))
private[this] lazy val admintools_Admin_bulkAddSingle32_invoker = createInvoker(
admintools.Admin.bulkAddSingle(),
HandlerDef(this.getClass.getClassLoader, "", "admintools.Admin", "bulkAddSingle", Nil,"GET", """""", Routes.prefix + """admin/api/bulkaddsingle"""))
        

// @LINE:48
private[this] lazy val article_ArticleIn_index33_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("artikkel/ny"))))
private[this] lazy val article_ArticleIn_index33_invoker = createInvoker(
article.ArticleIn.index(),
HandlerDef(this.getClass.getClassLoader, "", "article.ArticleIn", "index", Nil,"GET", """ # Article and events""", Routes.prefix + """artikkel/ny"""))
        

// @LINE:49
private[this] lazy val article_ArticleIn_save34_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("artikkel/ny"))))
private[this] lazy val article_ArticleIn_save34_invoker = createInvoker(
article.ArticleIn.save(),
HandlerDef(this.getClass.getClassLoader, "", "article.ArticleIn", "save", Nil,"POST", """""", Routes.prefix + """artikkel/ny"""))
        

// @LINE:50
private[this] lazy val article_Article_viewArticle35_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("artikkel/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val article_Article_viewArticle35_invoker = createInvoker(
article.Article.viewArticle(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "article.Article", "viewArticle", Seq(classOf[String]),"GET", """""", Routes.prefix + """artikkel/$id<[^/]+>"""))
        

// @LINE:51
private[this] lazy val article_Article_editArticle36_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("artikkel/"),DynamicPart("id", """[^/]+""",true),StaticPart("/endre"))))
private[this] lazy val article_Article_editArticle36_invoker = createInvoker(
article.Article.editArticle(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "article.Article", "editArticle", Seq(classOf[String]),"GET", """""", Routes.prefix + """artikkel/$id<[^/]+>/endre"""))
        

// @LINE:53
private[this] lazy val article_ArticleIn_saveEdit37_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("artikkel/"),DynamicPart("id", """[^/]+""",true),StaticPart("/lagreEndring"))))
private[this] lazy val article_ArticleIn_saveEdit37_invoker = createInvoker(
article.ArticleIn.saveEdit(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "article.ArticleIn", "saveEdit", Seq(classOf[String]),"POST", """FIXME: Tillater vi stor bokstav i url-er?""", Routes.prefix + """artikkel/$id<[^/]+>/lagreEndring"""))
        

// @LINE:55
private[this] lazy val article_Event_viewEvent38_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val article_Event_viewEvent38_invoker = createInvoker(
article.Event.viewEvent(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "article.Event", "viewEvent", Seq(classOf[String]),"GET", """""", Routes.prefix + """event/$id<[^/]+>"""))
        

// @LINE:56
private[this] lazy val article_Event_editEvent39_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("id", """[^/]+""",true),StaticPart("/endre"))))
private[this] lazy val article_Event_editEvent39_invoker = createInvoker(
article.Event.editEvent(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "article.Event", "editEvent", Seq(classOf[String]),"GET", """""", Routes.prefix + """event/$id<[^/]+>/endre"""))
        

// @LINE:58
private[this] lazy val article_Event_saveEdit40_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("id", """[^/]+""",true),StaticPart("/lagreEndring"))))
private[this] lazy val article_Event_saveEdit40_invoker = createInvoker(
article.Event.saveEdit(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "article.Event", "saveEdit", Seq(classOf[String]),"POST", """FIXME: Tillater vi stor bokstav i url-er?""", Routes.prefix + """event/$id<[^/]+>/lagreEndring"""))
        

// @LINE:60
private[this] lazy val article_Event_updateUser41_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/meldpaa"))))
private[this] lazy val article_Event_updateUser41_invoker = createInvoker(
article.Event.updateUser(),
HandlerDef(this.getClass.getClassLoader, "", "article.Event", "updateUser", Nil,"POST", """ # Bruker current login cookie, og en eventId i POST""", Routes.prefix + """event/meldpaa"""))
        

// @LINE:61
private[this] lazy val article_Event_removeUser42_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/meldav"))))
private[this] lazy val article_Event_removeUser42_invoker = createInvoker(
article.Event.removeUser(),
HandlerDef(this.getClass.getClassLoader, "", "article.Event", "removeUser", Nil,"POST", """""", Routes.prefix + """event/meldav"""))
        

// @LINE:63
private[this] lazy val article_Article_comment43_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/"),DynamicPart("articleID", """[^/]+""",true))))
private[this] lazy val article_Article_comment43_invoker = createInvoker(
article.Article.comment(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "article.Article", "comment", Seq(classOf[String]),"POST", """""", Routes.prefix + """comment/$articleID<[^/]+>"""))
        

// @LINE:64
private[this] lazy val article_Article_deleteComment44_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/delete/"),DynamicPart("commentID", """[^/]+""",true))))
private[this] lazy val article_Article_deleteComment44_invoker = createInvoker(
article.Article.deleteComment(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "article.Article", "deleteComment", Seq(classOf[String]),"POST", """""", Routes.prefix + """comment/delete/$commentID<[^/]+>"""))
        

// @LINE:67
private[this] lazy val bedkomdatabase_Bedkomdatabase_index45_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase"))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_index45_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.index(),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "index", Nil,"GET", """ # Bedkom-database""", Routes.prefix + """bedkomdatabase"""))
        

// @LINE:69
private[this] lazy val bedkomdatabase_Bedkomdatabase_saveBedrift46_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/bedrift"))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_saveBedrift46_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.saveBedrift(),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "saveBedrift", Nil,"POST", """""", Routes.prefix + """bedkomdatabase/bedrift"""))
        

// @LINE:70
private[this] lazy val bedkomdatabase_Bedkomdatabase_updateBedrift47_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/bedrift/ud/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_updateBedrift47_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.updateBedrift(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "updateBedrift", Seq(classOf[String]),"POST", """""", Routes.prefix + """bedkomdatabase/bedrift/ud/$id<[^/]+>"""))
        

// @LINE:71
private[this] lazy val bedkomdatabase_Bedkomdatabase_deleteBedrift48_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/bedrift/slett/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_deleteBedrift48_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.deleteBedrift(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "deleteBedrift", Seq(classOf[String]),"POST", """""", Routes.prefix + """bedkomdatabase/bedrift/slett/$id<[^/]+>"""))
        

// @LINE:73
private[this] lazy val bedkomdatabase_Bedkomdatabase_saveKontaktPerson49_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/kontakt/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_saveKontaktPerson49_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.saveKontaktPerson(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "saveKontaktPerson", Seq(classOf[String]),"POST", """""", Routes.prefix + """bedkomdatabase/kontakt/$id<[^/]+>"""))
        

// @LINE:74
private[this] lazy val bedkomdatabase_Bedkomdatabase_deleteKontaktPerson50_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/kontakt/slett/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_deleteKontaktPerson50_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.deleteKontaktPerson(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "deleteKontaktPerson", Seq(classOf[String]),"POST", """""", Routes.prefix + """bedkomdatabase/kontakt/slett/$id<[^/]+>"""))
        

// @LINE:75
private[this] lazy val bedkomdatabase_Bedkomdatabase_updateKontaktPerson51_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/kontakt/ud/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_updateKontaktPerson51_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.updateKontaktPerson(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "updateKontaktPerson", Seq(classOf[String]),"POST", """""", Routes.prefix + """bedkomdatabase/kontakt/ud/$id<[^/]+>"""))
        

// @LINE:77
private[this] lazy val bedkomdatabase_Bedkomdatabase_saveNote52_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/notat/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_saveNote52_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.saveNote(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "saveNote", Seq(classOf[String]),"POST", """""", Routes.prefix + """bedkomdatabase/notat/$id<[^/]+>"""))
        

// @LINE:78
private[this] lazy val bedkomdatabase_Bedkomdatabase_updateNote53_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/notat/ud/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_updateNote53_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.updateNote(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "updateNote", Seq(classOf[String]),"POST", """""", Routes.prefix + """bedkomdatabase/notat/ud/$id<[^/]+>"""))
        

// @LINE:79
private[this] lazy val bedkomdatabase_Bedkomdatabase_deleteNote54_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomdatabase/notat/slett/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val bedkomdatabase_Bedkomdatabase_deleteNote54_invoker = createInvoker(
bedkomdatabase.Bedkomdatabase.deleteNote(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bedkomdatabase.Bedkomdatabase", "deleteNote", Seq(classOf[String]),"POST", """""", Routes.prefix + """bedkomdatabase/notat/slett/$id<[^/]+>"""))
        

// @LINE:82
private[this] lazy val bedpressblock_BedPresBlock_index55_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomblokkering"))))
private[this] lazy val bedpressblock_BedPresBlock_index55_invoker = createInvoker(
bedpressblock.BedPresBlock.index(),
HandlerDef(this.getClass.getClassLoader, "", "bedpressblock.BedPresBlock", "index", Nil,"GET", """ # Bedkom Blocking""", Routes.prefix + """bedkomblokkering"""))
        

// @LINE:83
private[this] lazy val bedpressblock_BedPresBlock_pickUsers56_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomblokkering"))))
private[this] lazy val bedpressblock_BedPresBlock_pickUsers56_invoker = createInvoker(
bedpressblock.BedPresBlock.pickUsers(),
HandlerDef(this.getClass.getClassLoader, "", "bedpressblock.BedPresBlock", "pickUsers", Nil,"POST", """""", Routes.prefix + """bedkomblokkering"""))
        

// @LINE:84
private[this] lazy val bedpressblock_BedPresBlock_blockUser57_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bedkomblokkering/blokker"))))
private[this] lazy val bedpressblock_BedPresBlock_blockUser57_invoker = createInvoker(
bedpressblock.BedPresBlock.blockUser(),
HandlerDef(this.getClass.getClassLoader, "", "bedpressblock.BedPresBlock", "blockUser", Nil,"POST", """""", Routes.prefix + """bedkomblokkering/blokker"""))
        

// @LINE:87
private[this] lazy val calendar_Calendar_display58_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("kalender"))))
private[this] lazy val calendar_Calendar_display58_invoker = createInvoker(
calendar.Calendar.display(fakeValue[Boolean]),
HandlerDef(this.getClass.getClassLoader, "", "calendar.Calendar", "display", Seq(classOf[Boolean]),"GET", """ # Calendar""", Routes.prefix + """kalender"""))
        

// @LINE:88
private[this] lazy val calendar_Calendar_fetch59_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/kalender/hent"))))
private[this] lazy val calendar_Calendar_fetch59_invoker = createInvoker(
calendar.Calendar.fetch(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "calendar.Calendar", "fetch", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """api/kalender/hent"""))
        

// @LINE:89
private[this] lazy val calendar_Calendar_change60_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/kalender/endre"))))
private[this] lazy val calendar_Calendar_change60_invoker = createInvoker(
calendar.Calendar.change(),
HandlerDef(this.getClass.getClassLoader, "", "calendar.Calendar", "change", Nil,"POST", """""", Routes.prefix + """api/kalender/endre"""))
        

// @LINE:92
private[this] lazy val gallery_Gallery_display61_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("galleri"))))
private[this] lazy val gallery_Gallery_display61_invoker = createInvoker(
gallery.Gallery.display(),
HandlerDef(this.getClass.getClassLoader, "", "gallery.Gallery", "display", Nil,"GET", """ # Gallery""", Routes.prefix + """galleri"""))
        

// @LINE:93
private[this] lazy val gallery_Gallery_uploadGalleryImage62_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/submitImage"))))
private[this] lazy val gallery_Gallery_uploadGalleryImage62_invoker = createInvoker(
gallery.Gallery.uploadGalleryImage(),
HandlerDef(this.getClass.getClassLoader, "", "gallery.Gallery", "uploadGalleryImage", Nil,"POST", """""", Routes.prefix + """api/submitImage"""))
        

// @LINE:94
private[this] lazy val gallery_Gallery_giveImageClickScore63_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/clickScoreImage"))))
private[this] lazy val gallery_Gallery_giveImageClickScore63_invoker = createInvoker(
gallery.Gallery.giveImageClickScore(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "gallery.Gallery", "giveImageClickScore", Seq(classOf[Long]),"GET", """""", Routes.prefix + """api/clickScoreImage"""))
        

// @LINE:97
private[this] lazy val sso_SSOLogin_login64_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val sso_SSOLogin_login64_invoker = createInvoker(
sso.SSOLogin.login(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "sso.SSOLogin", "login", Seq(classOf[String]),"GET", """ # Login""", Routes.prefix + """login"""))
        

// @LINE:98
private[this] lazy val sso_SSOLogin_logout65_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val sso_SSOLogin_logout65_invoker = createInvoker(
sso.SSOLogin.logout(),
HandlerDef(this.getClass.getClassLoader, "", "sso.SSOLogin", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:99
private[this] lazy val sso_SSOLogin_verifylogin66_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("verifylogin"))))
private[this] lazy val sso_SSOLogin_verifylogin66_invoker = createInvoker(
sso.SSOLogin.verifylogin(),
HandlerDef(this.getClass.getClassLoader, "", "sso.SSOLogin", "verifylogin", Nil,"GET", """""", Routes.prefix + """verifylogin"""))
        

// @LINE:100
private[this] lazy val contactforuser_ContactForUser_index67_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("kontaktforbruker"))))
private[this] lazy val contactforuser_ContactForUser_index67_invoker = createInvoker(
contactforuser.ContactForUser.index(),
HandlerDef(this.getClass.getClassLoader, "", "contactforuser.ContactForUser", "index", Nil,"GET", """""", Routes.prefix + """kontaktforbruker"""))
        

// @LINE:103
private[this] lazy val profile_Profile_index68_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profil/"),DynamicPart("username", """[^/]+""",true))))
private[this] lazy val profile_Profile_index68_invoker = createInvoker(
profile.Profile.index(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "profile.Profile", "index", Seq(classOf[String]),"GET", """ # Profile""", Routes.prefix + """profil/$username<[^/]+>"""))
        

// @LINE:104
private[this] lazy val profile_Profile_edit69_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profil/"),DynamicPart("username", """[^/]+""",true),StaticPart("/rediger"))))
private[this] lazy val profile_Profile_edit69_invoker = createInvoker(
profile.Profile.edit(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "profile.Profile", "edit", Seq(classOf[String]),"GET", """""", Routes.prefix + """profil/$username<[^/]+>/rediger"""))
        

// @LINE:105
private[this] lazy val profile_Profile_update70_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profil/"),DynamicPart("username", """[^/]+""",true),StaticPart("/rediger"))))
private[this] lazy val profile_Profile_update70_invoker = createInvoker(
profile.Profile.update(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "profile.Profile", "update", Seq(classOf[String]),"POST", """""", Routes.prefix + """profil/$username<[^/]+>/rediger"""))
        

// @LINE:108
private[this] lazy val quiz_QuizController_index71_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("quiz"))))
private[this] lazy val quiz_QuizController_index71_invoker = createInvoker(
quiz.QuizController.index(),
HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "index", Nil,"GET", """ # Quiz""", Routes.prefix + """quiz"""))
        

// @LINE:109
private[this] lazy val quiz_QuizController_quizTeams72_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/quiz/teams"))))
private[this] lazy val quiz_QuizController_quizTeams72_invoker = createInvoker(
quiz.QuizController.quizTeams(),
HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "quizTeams", Nil,"GET", """""", Routes.prefix + """api/quiz/teams"""))
        

// @LINE:110
private[this] lazy val quiz_QuizController_putTeam73_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/quiz/team"))))
private[this] lazy val quiz_QuizController_putTeam73_invoker = createInvoker(
quiz.QuizController.putTeam(),
HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "putTeam", Nil,"PUT", """""", Routes.prefix + """api/quiz/team"""))
        

// @LINE:111
private[this] lazy val quiz_QuizController_deleteTeamById74_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/quiz/team/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val quiz_QuizController_deleteTeamById74_invoker = createInvoker(
quiz.QuizController.deleteTeamById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "deleteTeamById", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """api/quiz/team/$id<[^/]+>"""))
        

// @LINE:112
private[this] lazy val quiz_QuizController_quizSeasons75_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/quiz/seasons"))))
private[this] lazy val quiz_QuizController_quizSeasons75_invoker = createInvoker(
quiz.QuizController.quizSeasons(),
HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "quizSeasons", Nil,"GET", """""", Routes.prefix + """api/quiz/seasons"""))
        

// @LINE:113
private[this] lazy val quiz_QuizController_putSeason76_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/quiz/season"))))
private[this] lazy val quiz_QuizController_putSeason76_invoker = createInvoker(
quiz.QuizController.putSeason(),
HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "putSeason", Nil,"PUT", """""", Routes.prefix + """api/quiz/season"""))
        

// @LINE:114
private[this] lazy val quiz_QuizController_deleteSeasonById77_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/quiz/season/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val quiz_QuizController_deleteSeasonById77_invoker = createInvoker(
quiz.QuizController.deleteSeasonById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "quiz.QuizController", "deleteSeasonById", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """api/quiz/season/$id<[^/]+>"""))
        

// @LINE:117
private[this] lazy val rfid_RFIDReader_index78_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rfid"))))
private[this] lazy val rfid_RFIDReader_index78_invoker = createInvoker(
rfid.RFIDReader.index(),
HandlerDef(this.getClass.getClassLoader, "", "rfid.RFIDReader", "index", Nil,"GET", """ # RFID""", Routes.prefix + """rfid"""))
        

// @LINE:118
private[this] lazy val rfid_RFIDReader_indexContinue79_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rfid/"),DynamicPart("status", """[^/]+""",true),StaticPart("/"),DynamicPart("number", """[^/]+""",true))))
private[this] lazy val rfid_RFIDReader_indexContinue79_invoker = createInvoker(
rfid.RFIDReader.indexContinue(fakeValue[String], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "rfid.RFIDReader", "indexContinue", Seq(classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """rfid/$status<[^/]+>/$number<[^/]+>"""))
        

// @LINE:119
private[this] lazy val rfid_RFIDReader_read80_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rfid"))))
private[this] lazy val rfid_RFIDReader_read80_invoker = createInvoker(
rfid.RFIDReader.read(),
HandlerDef(this.getClass.getClassLoader, "", "rfid.RFIDReader", "read", Nil,"POST", """""", Routes.prefix + """rfid"""))
        

// @LINE:122
private[this] lazy val renders_Search_search81_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search"))))
private[this] lazy val renders_Search_search81_invoker = createInvoker(
renders.Search.search(fakeValue[String], fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "renders.Search", "search", Seq(classOf[String], classOf[Int]),"GET", """ # Search""", Routes.prefix + """search"""))
        

// @LINE:125
private[this] lazy val timeline_Timeline_index82_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tidslinje"))))
private[this] lazy val timeline_Timeline_index82_invoker = createInvoker(
timeline.Timeline.index(),
HandlerDef(this.getClass.getClassLoader, "", "timeline.Timeline", "index", Nil,"GET", """ # Timeline""", Routes.prefix + """tidslinje"""))
        

// @LINE:128
private[this] lazy val update_Update_index83_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update"))))
private[this] lazy val update_Update_index83_invoker = createInvoker(
update.Update.index(),
HandlerDef(this.getClass.getClassLoader, "", "update.Update", "index", Nil,"GET", """ # Update""", Routes.prefix + """update"""))
        

// @LINE:129
private[this] lazy val update_Update_utgaver84_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update/utgaver"))))
private[this] lazy val update_Update_utgaver84_invoker = createInvoker(
update.Update.utgaver(),
HandlerDef(this.getClass.getClassLoader, "", "update.Update", "utgaver", Nil,"GET", """""", Routes.prefix + """update/utgaver"""))
        

// @LINE:130
private[this] lazy val update_Update_redaksjon85_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update/redaksjon"))))
private[this] lazy val update_Update_redaksjon85_invoker = createInvoker(
update.Update.redaksjon(),
HandlerDef(this.getClass.getClassLoader, "", "update.Update", "redaksjon", Nil,"GET", """""", Routes.prefix + """update/redaksjon"""))
        

// @LINE:133
private[this] lazy val ballot_VoteController_lazyRedirect86_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("gf"))))
private[this] lazy val ballot_VoteController_lazyRedirect86_invoker = createInvoker(
ballot.VoteController.lazyRedirect(),
HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "lazyRedirect", Nil,"GET", """ # Voting""", Routes.prefix + """gf"""))
        

// @LINE:134
private[this] lazy val ballot_VoteController_lazyRedirect87_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("genfors"))))
private[this] lazy val ballot_VoteController_lazyRedirect87_invoker = createInvoker(
ballot.VoteController.lazyRedirect(),
HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "lazyRedirect", Nil,"GET", """""", Routes.prefix + """genfors"""))
        

// @LINE:135
private[this] lazy val ballot_VoteController_index88_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("avstemning"))))
private[this] lazy val ballot_VoteController_index88_invoker = createInvoker(
ballot.VoteController.index(),
HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "index", Nil,"GET", """""", Routes.prefix + """avstemning"""))
        

// @LINE:136
private[this] lazy val ballot_VoteController_attemptVote89_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("avstemning"))))
private[this] lazy val ballot_VoteController_attemptVote89_invoker = createInvoker(
ballot.VoteController.attemptVote(),
HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "attemptVote", Nil,"POST", """""", Routes.prefix + """avstemning"""))
        

// @LINE:137
private[this] lazy val ballot_VoteController_getChoices90_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("avstemning/valg"))))
private[this] lazy val ballot_VoteController_getChoices90_invoker = createInvoker(
ballot.VoteController.getChoices,
HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "getChoices", Nil,"GET", """""", Routes.prefix + """avstemning/valg"""))
        

// @LINE:138
private[this] lazy val ballot_VoteController_overview91_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("avstemning/oversikt"))))
private[this] lazy val ballot_VoteController_overview91_invoker = createInvoker(
ballot.VoteController.overview(),
HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "overview", Nil,"GET", """""", Routes.prefix + """avstemning/oversikt"""))
        

// @LINE:139
private[this] lazy val ballot_VoteController_newBallot92_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("avstemning/oversikt"))))
private[this] lazy val ballot_VoteController_newBallot92_invoker = createInvoker(
ballot.VoteController.newBallot(),
HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "newBallot", Nil,"POST", """""", Routes.prefix + """avstemning/oversikt"""))
        

// @LINE:140
private[this] lazy val ballot_VoteController_getResults93_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("avstemning/resultater"))))
private[this] lazy val ballot_VoteController_getResults93_invoker = createInvoker(
ballot.VoteController.getResults,
HandlerDef(this.getClass.getClassLoader, "", "ballot.VoteController", "getResults", Nil,"GET", """""", Routes.prefix + """avstemning/resultater"""))
        

// @LINE:144
private[this] lazy val backup_BackupDatabase_index94_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/backup"))))
private[this] lazy val backup_BackupDatabase_index94_invoker = createInvoker(
backup.BackupDatabase.index(),
HandlerDef(this.getClass.getClassLoader, "", "backup.BackupDatabase", "index", Nil,"GET", """ API
 # Backup database""", Routes.prefix + """api/backup"""))
        

// @LINE:147
private[this] lazy val controllers_Upload_ajaxUpload95_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/upload"))))
private[this] lazy val controllers_Upload_ajaxUpload95_invoker = createInvoker(
controllers.Upload.ajaxUpload(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Upload", "ajaxUpload", Nil,"POST", """ # Upload files""", Routes.prefix + """api/upload"""))
        

// @LINE:148
private[this] lazy val controllers_Upload_ajaxUploadTo96_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/upload/"),DynamicPart("uploadFolder", """[^/]+""",true))))
private[this] lazy val controllers_Upload_ajaxUploadTo96_invoker = createInvoker(
controllers.Upload.ajaxUploadTo(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Upload", "ajaxUploadTo", Seq(classOf[String]),"POST", """""", Routes.prefix + """api/upload/$uploadFolder<[^/]+>"""))
        

// @LINE:152
private[this] lazy val chat_Chat_connectClient97_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("chat"))))
private[this] lazy val chat_Chat_connectClient97_invoker = createInvoker(
chat.Chat.connectClient(),
HandlerDef(this.getClass.getClassLoader, "", "chat.Chat", "connectClient", Nil,"GET", """ TEST
 # Chat""", Routes.prefix + """chat"""))
        

// @LINE:153
private[this] lazy val chat_Chat_socket98_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("chatserver"))))
private[this] lazy val chat_Chat_socket98_invoker = createInvoker(
chat.Chat.socket(),
HandlerDef(this.getClass.getClassLoader, "", "chat.Chat", "socket", Nil,"GET", """""", Routes.prefix + """chatserver"""))
        

// @LINE:157
private[this] lazy val examples_controllers_ExampleEbean_index99_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/ebean"))))
private[this] lazy val examples_controllers_ExampleEbean_index99_invoker = createInvoker(
examples.controllers.ExampleEbean.index(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleEbean", "index", Nil,"GET", """ EXAMPLES
 # Ebean""", Routes.prefix + """examples/ebean"""))
        

// @LINE:158
private[this] lazy val examples_controllers_ExampleEbean_add100_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/ebean"))))
private[this] lazy val examples_controllers_ExampleEbean_add100_invoker = createInvoker(
examples.controllers.ExampleEbean.add(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleEbean", "add", Nil,"POST", """""", Routes.prefix + """examples/ebean"""))
        

// @LINE:159
private[this] lazy val examples_controllers_ExampleEbean_clear101_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/ebean/clear"))))
private[this] lazy val examples_controllers_ExampleEbean_clear101_invoker = createInvoker(
examples.controllers.ExampleEbean.clear(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleEbean", "clear", Nil,"POST", """""", Routes.prefix + """examples/ebean/clear"""))
        

// @LINE:161
private[this] lazy val examples_controllers_ExampleImageUpload_index102_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/imageupload"))))
private[this] lazy val examples_controllers_ExampleImageUpload_index102_invoker = createInvoker(
examples.controllers.ExampleImageUpload.index(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleImageUpload", "index", Nil,"GET", """ # ImageUpload""", Routes.prefix + """examples/imageupload"""))
        

// @LINE:162
private[this] lazy val examples_controllers_ExampleImageUpload_upload103_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/imageupload"))))
private[this] lazy val examples_controllers_ExampleImageUpload_upload103_invoker = createInvoker(
examples.controllers.ExampleImageUpload.upload(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleImageUpload", "upload", Nil,"POST", """""", Routes.prefix + """examples/imageupload"""))
        

// @LINE:164
private[this] lazy val examples_controllers_ExampleCookies_index104_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/cookies"))))
private[this] lazy val examples_controllers_ExampleCookies_index104_invoker = createInvoker(
examples.controllers.ExampleCookies.index(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleCookies", "index", Nil,"GET", """ # Cookies""", Routes.prefix + """examples/cookies"""))
        

// @LINE:165
private[this] lazy val examples_controllers_ExampleCookies_clearAllCookies105_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/cookies/clear"))))
private[this] lazy val examples_controllers_ExampleCookies_clearAllCookies105_invoker = createInvoker(
examples.controllers.ExampleCookies.clearAllCookies(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleCookies", "clearAllCookies", Nil,"POST", """""", Routes.prefix + """examples/cookies/clear"""))
        

// @LINE:166
private[this] lazy val examples_controllers_ExampleCookies_clearAllCookies106_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/cookies/clear"))))
private[this] lazy val examples_controllers_ExampleCookies_clearAllCookies106_invoker = createInvoker(
examples.controllers.ExampleCookies.clearAllCookies(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleCookies", "clearAllCookies", Nil,"GET", """""", Routes.prefix + """examples/cookies/clear"""))
        

// @LINE:168
private[this] lazy val examples_controllers_ExampleDatabase_index107_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/database"))))
private[this] lazy val examples_controllers_ExampleDatabase_index107_invoker = createInvoker(
examples.controllers.ExampleDatabase.index(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleDatabase", "index", Nil,"GET", """ # Database""", Routes.prefix + """examples/database"""))
        

// @LINE:170
private[this] lazy val examples_controllers_ExampleAngular_index108_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/angular"))))
private[this] lazy val examples_controllers_ExampleAngular_index108_invoker = createInvoker(
examples.controllers.ExampleAngular.index(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleAngular", "index", Nil,"GET", """ # AngularJS""", Routes.prefix + """examples/angular"""))
        

// @LINE:172
private[this] lazy val examples_controllers_ExampleStaticAccess_index109_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("examples/access"))))
private[this] lazy val examples_controllers_ExampleStaticAccess_index109_invoker = createInvoker(
examples.controllers.ExampleStaticAccess.index(),
HandlerDef(this.getClass.getClassLoader, "", "examples.controllers.ExampleStaticAccess", "index", Nil,"GET", """ # Limited Access""", Routes.prefix + """examples/access"""))
        

// @LINE:175
private[this] lazy val redir_Redir_artikler110_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("artikler/"),DynamicPart("path", """.+""",false))))
private[this] lazy val redir_Redir_artikler110_invoker = createInvoker(
redir.Redir.artikler(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "redir.Redir", "artikler", Seq(classOf[String]),"GET", """ REDIRECT OLD""", Routes.prefix + """artikler/$path<.+>"""))
        

// @LINE:176
private[this] lazy val redir_Redir_nyheter111_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nyheter"))))
private[this] lazy val redir_Redir_nyheter111_invoker = createInvoker(
redir.Redir.nyheter(),
HandlerDef(this.getClass.getClassLoader, "", "redir.Redir", "nyheter", Nil,"GET", """""", Routes.prefix + """nyheter"""))
        

// @LINE:179
private[this] lazy val controllers_Assets_at112_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at112_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:181
private[this] lazy val controllers_Restricted_at113_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("begrenset/"),DynamicPart("restriction", """[^/]+""",true),StaticPart("/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Restricted_at113_invoker = createInvoker(
controllers.Restricted.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Restricted", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources with restricted access from the /restricted folder to the /begrenset URL path""", Routes.prefix + """begrenset/$restriction<[^/]+>/$file<.+>"""))
        

// @LINE:184
private[this] lazy val application_Application_showUnauthorizedAccess114_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("unauthorized"))))
private[this] lazy val application_Application_showUnauthorizedAccess114_invoker = createInvoker(
application.Application.showUnauthorizedAccess(),
HandlerDef(this.getClass.getClassLoader, "", "application.Application", "showUnauthorizedAccess", Nil,"GET", """FIXME: Controllers burde kanskje returnere Application.showUnauthorizedAccess() heller enn å redirecte dit?""", Routes.prefix + """unauthorized"""))
        

// @LINE:187
private[this] lazy val application_Application_show400115_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("error400/"),DynamicPart("error", """[^/]+""",true))))
private[this] lazy val application_Application_show400115_invoker = createInvoker(
application.Application.show400(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "application.Application", "show400", Seq(classOf[String]),"GET", """ Show some page describing the URL if all else fails""", Routes.prefix + """error400/$error<[^/]+>"""))
        

// @LINE:188
private[this] lazy val application_Application_show404116_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("anything", """.*""",false))))
private[this] lazy val application_Application_show404116_invoker = createInvoker(
application.Application.show404(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "application.Application", "show404", Seq(classOf[String]),"GET", """""", Routes.prefix + """$anything<.*>"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$path<.+>/""","""application.Application.untrail(path:String)"""),("""GET""", prefix,"""application.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """forside""","""application.Application.forside()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """insertqt""","""test.TestDatabase.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arrkom""","""staticpages.About.arrkom()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedrift""","""staticpages.Bedrift.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedriftspresentasjon""","""staticpages.Ringen.bedriftspresentasjoner()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkom""","""staticpages.About.bedkom()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ekskursjoner""","""staticpages.Ringen.ekskursjoner()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """griffensorden""","""griffensorden.GriffensOrden.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """griffensorden/riddere""","""griffensorden.GriffensOrden.riddere()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """griffensorden/nominasjon""","""griffensorden.GriffensOrden.nomination()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """info""","""staticpages.About.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """i&iktringen""","""staticpages.Ringen.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """i&iktringen/om""","""staticpages.Ringen.about()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jentekom""","""staticpages.About.jentekom()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nystudent""","""staticpages.About.newStudent()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """redaksjonen""","""staticpages.About.redaksjonen()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """statutter""","""staticpages.Statutter.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """strikk""","""strikk.HybridaStrikk.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """styret""","""staticpages.About.styret()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tillitsvalgte""","""staticpages.Tillitsvalgte.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """vevkom""","""staticpages.About.vevkom()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin""","""admintools.Admin.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/login""","""admintools.Admin.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/rediger""","""admintools.Admin.editUser(uid:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/logout""","""admintools.Admin.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/logout""","""admintools.Admin.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/users""","""admintools.Admin.allUsers()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/newuser""","""admintools.Admin.newUser()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/bulkusers""","""admintools.Admin.bulkUsersForm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/bulkusers""","""admintools.Admin.bulkUsers()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/api/bulkaddsingle""","""admintools.Admin.bulkAddSingle()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """artikkel/ny""","""article.ArticleIn.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """artikkel/ny""","""article.ArticleIn.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """artikkel/$id<[^/]+>""","""article.Article.viewArticle(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """artikkel/$id<[^/]+>/endre""","""article.Article.editArticle(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """artikkel/$id<[^/]+>/lagreEndring""","""article.ArticleIn.saveEdit(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$id<[^/]+>""","""article.Event.viewEvent(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$id<[^/]+>/endre""","""article.Event.editEvent(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$id<[^/]+>/lagreEndring""","""article.Event.saveEdit(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/meldpaa""","""article.Event.updateUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/meldav""","""article.Event.removeUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/$articleID<[^/]+>""","""article.Article.comment(articleID:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/delete/$commentID<[^/]+>""","""article.Article.deleteComment(commentID:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase""","""bedkomdatabase.Bedkomdatabase.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/bedrift""","""bedkomdatabase.Bedkomdatabase.saveBedrift()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/bedrift/ud/$id<[^/]+>""","""bedkomdatabase.Bedkomdatabase.updateBedrift(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/bedrift/slett/$id<[^/]+>""","""bedkomdatabase.Bedkomdatabase.deleteBedrift(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/kontakt/$id<[^/]+>""","""bedkomdatabase.Bedkomdatabase.saveKontaktPerson(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/kontakt/slett/$id<[^/]+>""","""bedkomdatabase.Bedkomdatabase.deleteKontaktPerson(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/kontakt/ud/$id<[^/]+>""","""bedkomdatabase.Bedkomdatabase.updateKontaktPerson(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/notat/$id<[^/]+>""","""bedkomdatabase.Bedkomdatabase.saveNote(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/notat/ud/$id<[^/]+>""","""bedkomdatabase.Bedkomdatabase.updateNote(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomdatabase/notat/slett/$id<[^/]+>""","""bedkomdatabase.Bedkomdatabase.deleteNote(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomblokkering""","""bedpressblock.BedPresBlock.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomblokkering""","""bedpressblock.BedPresBlock.pickUsers()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bedkomblokkering/blokker""","""bedpressblock.BedPresBlock.blockUser()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """kalender""","""calendar.Calendar.display(gcal:Boolean ?= false)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/kalender/hent""","""calendar.Calendar.fetch(start:String, end:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/kalender/endre""","""calendar.Calendar.change()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """galleri""","""gallery.Gallery.display()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/submitImage""","""gallery.Gallery.uploadGalleryImage()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/clickScoreImage""","""gallery.Gallery.giveImageClickScore(imageId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""sso.SSOLogin.login(returnarg:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""sso.SSOLogin.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """verifylogin""","""sso.SSOLogin.verifylogin()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """kontaktforbruker""","""contactforuser.ContactForUser.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profil/$username<[^/]+>""","""profile.Profile.index(username:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profil/$username<[^/]+>/rediger""","""profile.Profile.edit(username:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profil/$username<[^/]+>/rediger""","""profile.Profile.update(username:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """quiz""","""quiz.QuizController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/quiz/teams""","""quiz.QuizController.quizTeams()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/quiz/team""","""quiz.QuizController.putTeam()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/quiz/team/$id<[^/]+>""","""quiz.QuizController.deleteTeamById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/quiz/seasons""","""quiz.QuizController.quizSeasons()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/quiz/season""","""quiz.QuizController.putSeason()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/quiz/season/$id<[^/]+>""","""quiz.QuizController.deleteSeasonById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rfid""","""rfid.RFIDReader.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rfid/$status<[^/]+>/$number<[^/]+>""","""rfid.RFIDReader.indexContinue(status:String, number:String, eventId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rfid""","""rfid.RFIDReader.read()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search""","""renders.Search.search(term:String ?= "", page:Int ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tidslinje""","""timeline.Timeline.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update""","""update.Update.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update/utgaver""","""update.Update.utgaver()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update/redaksjon""","""update.Update.redaksjon()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """gf""","""ballot.VoteController.lazyRedirect()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """genfors""","""ballot.VoteController.lazyRedirect()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """avstemning""","""ballot.VoteController.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """avstemning""","""ballot.VoteController.attemptVote()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """avstemning/valg""","""ballot.VoteController.getChoices"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """avstemning/oversikt""","""ballot.VoteController.overview()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """avstemning/oversikt""","""ballot.VoteController.newBallot()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """avstemning/resultater""","""ballot.VoteController.getResults"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/backup""","""backup.BackupDatabase.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/upload""","""controllers.Upload.ajaxUpload()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/upload/$uploadFolder<[^/]+>""","""controllers.Upload.ajaxUploadTo(uploadFolder:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """chat""","""chat.Chat.connectClient()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """chatserver""","""chat.Chat.socket()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/ebean""","""examples.controllers.ExampleEbean.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/ebean""","""examples.controllers.ExampleEbean.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/ebean/clear""","""examples.controllers.ExampleEbean.clear()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/imageupload""","""examples.controllers.ExampleImageUpload.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/imageupload""","""examples.controllers.ExampleImageUpload.upload()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/cookies""","""examples.controllers.ExampleCookies.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/cookies/clear""","""examples.controllers.ExampleCookies.clearAllCookies()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/cookies/clear""","""examples.controllers.ExampleCookies.clearAllCookies()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/database""","""examples.controllers.ExampleDatabase.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/angular""","""examples.controllers.ExampleAngular.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """examples/access""","""examples.controllers.ExampleStaticAccess.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """artikler/$path<.+>""","""redir.Redir.artikler(path:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nyheter""","""redir.Redir.nyheter()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """begrenset/$restriction<[^/]+>/$file<.+>""","""controllers.Restricted.at(restriction:String, file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """unauthorized""","""application.Application.showUnauthorizedAccess()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """error400/$error<[^/]+>""","""application.Application.show400(error:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$anything<.*>""","""application.Application.show404(anything:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:5
case application_Application_untrail0_route(params) => {
   call(params.fromPath[String]("path", None)) { (path) =>
        application_Application_untrail0_invoker.call(application.Application.untrail(path))
   }
}
        

// @LINE:8
case application_Application_index1_route(params) => {
   call { 
        application_Application_index1_invoker.call(application.Application.index())
   }
}
        

// @LINE:9
case application_Application_forside2_route(params) => {
   call { 
        application_Application_forside2_invoker.call(application.Application.forside())
   }
}
        

// @LINE:10
case test_TestDatabase_index3_route(params) => {
   call { 
        test_TestDatabase_index3_invoker.call(test.TestDatabase.index())
   }
}
        

// @LINE:13
case staticpages_About_arrkom4_route(params) => {
   call { 
        staticpages_About_arrkom4_invoker.call(staticpages.About.arrkom())
   }
}
        

// @LINE:14
case staticpages_Bedrift_index5_route(params) => {
   call { 
        staticpages_Bedrift_index5_invoker.call(staticpages.Bedrift.index())
   }
}
        

// @LINE:15
case staticpages_Ringen_bedriftspresentasjoner6_route(params) => {
   call { 
        staticpages_Ringen_bedriftspresentasjoner6_invoker.call(staticpages.Ringen.bedriftspresentasjoner())
   }
}
        

// @LINE:16
case staticpages_About_bedkom7_route(params) => {
   call { 
        staticpages_About_bedkom7_invoker.call(staticpages.About.bedkom())
   }
}
        

// @LINE:17
case staticpages_Ringen_ekskursjoner8_route(params) => {
   call { 
        staticpages_Ringen_ekskursjoner8_invoker.call(staticpages.Ringen.ekskursjoner())
   }
}
        

// @LINE:18
case griffensorden_GriffensOrden_index9_route(params) => {
   call { 
        griffensorden_GriffensOrden_index9_invoker.call(griffensorden.GriffensOrden.index())
   }
}
        

// @LINE:19
case griffensorden_GriffensOrden_riddere10_route(params) => {
   call { 
        griffensorden_GriffensOrden_riddere10_invoker.call(griffensorden.GriffensOrden.riddere())
   }
}
        

// @LINE:20
case griffensorden_GriffensOrden_nomination11_route(params) => {
   call { 
        griffensorden_GriffensOrden_nomination11_invoker.call(griffensorden.GriffensOrden.nomination())
   }
}
        

// @LINE:21
case staticpages_About_index12_route(params) => {
   call { 
        staticpages_About_index12_invoker.call(staticpages.About.index())
   }
}
        

// @LINE:22
case staticpages_Ringen_index13_route(params) => {
   call { 
        staticpages_Ringen_index13_invoker.call(staticpages.Ringen.index())
   }
}
        

// @LINE:23
case staticpages_Ringen_about14_route(params) => {
   call { 
        staticpages_Ringen_about14_invoker.call(staticpages.Ringen.about())
   }
}
        

// @LINE:24
case staticpages_About_jentekom15_route(params) => {
   call { 
        staticpages_About_jentekom15_invoker.call(staticpages.About.jentekom())
   }
}
        

// @LINE:25
case staticpages_About_newStudent16_route(params) => {
   call { 
        staticpages_About_newStudent16_invoker.call(staticpages.About.newStudent())
   }
}
        

// @LINE:26
case staticpages_About_redaksjonen17_route(params) => {
   call { 
        staticpages_About_redaksjonen17_invoker.call(staticpages.About.redaksjonen())
   }
}
        

// @LINE:27
case staticpages_Statutter_index18_route(params) => {
   call { 
        staticpages_Statutter_index18_invoker.call(staticpages.Statutter.index())
   }
}
        

// @LINE:28
case strikk_HybridaStrikk_index19_route(params) => {
   call { 
        strikk_HybridaStrikk_index19_invoker.call(strikk.HybridaStrikk.index())
   }
}
        

// @LINE:29
case staticpages_About_styret20_route(params) => {
   call { 
        staticpages_About_styret20_invoker.call(staticpages.About.styret())
   }
}
        

// @LINE:30
case staticpages_Tillitsvalgte_index21_route(params) => {
   call { 
        staticpages_Tillitsvalgte_index21_invoker.call(staticpages.Tillitsvalgte.index())
   }
}
        

// @LINE:31
case staticpages_About_vevkom22_route(params) => {
   call { 
        staticpages_About_vevkom22_invoker.call(staticpages.About.vevkom())
   }
}
        

// @LINE:36
case admintools_Admin_index23_route(params) => {
   call { 
        admintools_Admin_index23_invoker.call(admintools.Admin.index())
   }
}
        

// @LINE:37
case admintools_Admin_login24_route(params) => {
   call { 
        admintools_Admin_login24_invoker.call(admintools.Admin.login())
   }
}
        

// @LINE:38
case admintools_Admin_editUser25_route(params) => {
   call(params.fromQuery[String]("uid", None)) { (uid) =>
        admintools_Admin_editUser25_invoker.call(admintools.Admin.editUser(uid))
   }
}
        

// @LINE:39
case admintools_Admin_logout26_route(params) => {
   call { 
        admintools_Admin_logout26_invoker.call(admintools.Admin.logout())
   }
}
        

// @LINE:40
case admintools_Admin_logout27_route(params) => {
   call { 
        admintools_Admin_logout27_invoker.call(admintools.Admin.logout())
   }
}
        

// @LINE:41
case admintools_Admin_allUsers28_route(params) => {
   call { 
        admintools_Admin_allUsers28_invoker.call(admintools.Admin.allUsers())
   }
}
        

// @LINE:42
case admintools_Admin_newUser29_route(params) => {
   call { 
        admintools_Admin_newUser29_invoker.call(admintools.Admin.newUser())
   }
}
        

// @LINE:43
case admintools_Admin_bulkUsersForm30_route(params) => {
   call { 
        admintools_Admin_bulkUsersForm30_invoker.call(admintools.Admin.bulkUsersForm())
   }
}
        

// @LINE:44
case admintools_Admin_bulkUsers31_route(params) => {
   call { 
        admintools_Admin_bulkUsers31_invoker.call(admintools.Admin.bulkUsers())
   }
}
        

// @LINE:45
case admintools_Admin_bulkAddSingle32_route(params) => {
   call { 
        admintools_Admin_bulkAddSingle32_invoker.call(admintools.Admin.bulkAddSingle())
   }
}
        

// @LINE:48
case article_ArticleIn_index33_route(params) => {
   call { 
        article_ArticleIn_index33_invoker.call(article.ArticleIn.index())
   }
}
        

// @LINE:49
case article_ArticleIn_save34_route(params) => {
   call { 
        article_ArticleIn_save34_invoker.call(article.ArticleIn.save())
   }
}
        

// @LINE:50
case article_Article_viewArticle35_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        article_Article_viewArticle35_invoker.call(article.Article.viewArticle(id))
   }
}
        

// @LINE:51
case article_Article_editArticle36_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        article_Article_editArticle36_invoker.call(article.Article.editArticle(id))
   }
}
        

// @LINE:53
case article_ArticleIn_saveEdit37_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        article_ArticleIn_saveEdit37_invoker.call(article.ArticleIn.saveEdit(id))
   }
}
        

// @LINE:55
case article_Event_viewEvent38_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        article_Event_viewEvent38_invoker.call(article.Event.viewEvent(id))
   }
}
        

// @LINE:56
case article_Event_editEvent39_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        article_Event_editEvent39_invoker.call(article.Event.editEvent(id))
   }
}
        

// @LINE:58
case article_Event_saveEdit40_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        article_Event_saveEdit40_invoker.call(article.Event.saveEdit(id))
   }
}
        

// @LINE:60
case article_Event_updateUser41_route(params) => {
   call { 
        article_Event_updateUser41_invoker.call(article.Event.updateUser())
   }
}
        

// @LINE:61
case article_Event_removeUser42_route(params) => {
   call { 
        article_Event_removeUser42_invoker.call(article.Event.removeUser())
   }
}
        

// @LINE:63
case article_Article_comment43_route(params) => {
   call(params.fromPath[String]("articleID", None)) { (articleID) =>
        article_Article_comment43_invoker.call(article.Article.comment(articleID))
   }
}
        

// @LINE:64
case article_Article_deleteComment44_route(params) => {
   call(params.fromPath[String]("commentID", None)) { (commentID) =>
        article_Article_deleteComment44_invoker.call(article.Article.deleteComment(commentID))
   }
}
        

// @LINE:67
case bedkomdatabase_Bedkomdatabase_index45_route(params) => {
   call { 
        bedkomdatabase_Bedkomdatabase_index45_invoker.call(bedkomdatabase.Bedkomdatabase.index())
   }
}
        

// @LINE:69
case bedkomdatabase_Bedkomdatabase_saveBedrift46_route(params) => {
   call { 
        bedkomdatabase_Bedkomdatabase_saveBedrift46_invoker.call(bedkomdatabase.Bedkomdatabase.saveBedrift())
   }
}
        

// @LINE:70
case bedkomdatabase_Bedkomdatabase_updateBedrift47_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        bedkomdatabase_Bedkomdatabase_updateBedrift47_invoker.call(bedkomdatabase.Bedkomdatabase.updateBedrift(id))
   }
}
        

// @LINE:71
case bedkomdatabase_Bedkomdatabase_deleteBedrift48_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        bedkomdatabase_Bedkomdatabase_deleteBedrift48_invoker.call(bedkomdatabase.Bedkomdatabase.deleteBedrift(id))
   }
}
        

// @LINE:73
case bedkomdatabase_Bedkomdatabase_saveKontaktPerson49_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        bedkomdatabase_Bedkomdatabase_saveKontaktPerson49_invoker.call(bedkomdatabase.Bedkomdatabase.saveKontaktPerson(id))
   }
}
        

// @LINE:74
case bedkomdatabase_Bedkomdatabase_deleteKontaktPerson50_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        bedkomdatabase_Bedkomdatabase_deleteKontaktPerson50_invoker.call(bedkomdatabase.Bedkomdatabase.deleteKontaktPerson(id))
   }
}
        

// @LINE:75
case bedkomdatabase_Bedkomdatabase_updateKontaktPerson51_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        bedkomdatabase_Bedkomdatabase_updateKontaktPerson51_invoker.call(bedkomdatabase.Bedkomdatabase.updateKontaktPerson(id))
   }
}
        

// @LINE:77
case bedkomdatabase_Bedkomdatabase_saveNote52_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        bedkomdatabase_Bedkomdatabase_saveNote52_invoker.call(bedkomdatabase.Bedkomdatabase.saveNote(id))
   }
}
        

// @LINE:78
case bedkomdatabase_Bedkomdatabase_updateNote53_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        bedkomdatabase_Bedkomdatabase_updateNote53_invoker.call(bedkomdatabase.Bedkomdatabase.updateNote(id))
   }
}
        

// @LINE:79
case bedkomdatabase_Bedkomdatabase_deleteNote54_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        bedkomdatabase_Bedkomdatabase_deleteNote54_invoker.call(bedkomdatabase.Bedkomdatabase.deleteNote(id))
   }
}
        

// @LINE:82
case bedpressblock_BedPresBlock_index55_route(params) => {
   call { 
        bedpressblock_BedPresBlock_index55_invoker.call(bedpressblock.BedPresBlock.index())
   }
}
        

// @LINE:83
case bedpressblock_BedPresBlock_pickUsers56_route(params) => {
   call { 
        bedpressblock_BedPresBlock_pickUsers56_invoker.call(bedpressblock.BedPresBlock.pickUsers())
   }
}
        

// @LINE:84
case bedpressblock_BedPresBlock_blockUser57_route(params) => {
   call { 
        bedpressblock_BedPresBlock_blockUser57_invoker.call(bedpressblock.BedPresBlock.blockUser())
   }
}
        

// @LINE:87
case calendar_Calendar_display58_route(params) => {
   call(params.fromQuery[Boolean]("gcal", Some(false))) { (gcal) =>
        calendar_Calendar_display58_invoker.call(calendar.Calendar.display(gcal))
   }
}
        

// @LINE:88
case calendar_Calendar_fetch59_route(params) => {
   call(params.fromQuery[String]("start", None), params.fromQuery[String]("end", None)) { (start, end) =>
        calendar_Calendar_fetch59_invoker.call(calendar.Calendar.fetch(start, end))
   }
}
        

// @LINE:89
case calendar_Calendar_change60_route(params) => {
   call { 
        calendar_Calendar_change60_invoker.call(calendar.Calendar.change())
   }
}
        

// @LINE:92
case gallery_Gallery_display61_route(params) => {
   call { 
        gallery_Gallery_display61_invoker.call(gallery.Gallery.display())
   }
}
        

// @LINE:93
case gallery_Gallery_uploadGalleryImage62_route(params) => {
   call { 
        gallery_Gallery_uploadGalleryImage62_invoker.call(gallery.Gallery.uploadGalleryImage())
   }
}
        

// @LINE:94
case gallery_Gallery_giveImageClickScore63_route(params) => {
   call(params.fromQuery[Long]("imageId", None)) { (imageId) =>
        gallery_Gallery_giveImageClickScore63_invoker.call(gallery.Gallery.giveImageClickScore(imageId))
   }
}
        

// @LINE:97
case sso_SSOLogin_login64_route(params) => {
   call(params.fromQuery[String]("returnarg", None)) { (returnarg) =>
        sso_SSOLogin_login64_invoker.call(sso.SSOLogin.login(returnarg))
   }
}
        

// @LINE:98
case sso_SSOLogin_logout65_route(params) => {
   call { 
        sso_SSOLogin_logout65_invoker.call(sso.SSOLogin.logout())
   }
}
        

// @LINE:99
case sso_SSOLogin_verifylogin66_route(params) => {
   call { 
        sso_SSOLogin_verifylogin66_invoker.call(sso.SSOLogin.verifylogin())
   }
}
        

// @LINE:100
case contactforuser_ContactForUser_index67_route(params) => {
   call { 
        contactforuser_ContactForUser_index67_invoker.call(contactforuser.ContactForUser.index())
   }
}
        

// @LINE:103
case profile_Profile_index68_route(params) => {
   call(params.fromPath[String]("username", None)) { (username) =>
        profile_Profile_index68_invoker.call(profile.Profile.index(username))
   }
}
        

// @LINE:104
case profile_Profile_edit69_route(params) => {
   call(params.fromPath[String]("username", None)) { (username) =>
        profile_Profile_edit69_invoker.call(profile.Profile.edit(username))
   }
}
        

// @LINE:105
case profile_Profile_update70_route(params) => {
   call(params.fromPath[String]("username", None)) { (username) =>
        profile_Profile_update70_invoker.call(profile.Profile.update(username))
   }
}
        

// @LINE:108
case quiz_QuizController_index71_route(params) => {
   call { 
        quiz_QuizController_index71_invoker.call(quiz.QuizController.index())
   }
}
        

// @LINE:109
case quiz_QuizController_quizTeams72_route(params) => {
   call { 
        quiz_QuizController_quizTeams72_invoker.call(quiz.QuizController.quizTeams())
   }
}
        

// @LINE:110
case quiz_QuizController_putTeam73_route(params) => {
   call { 
        quiz_QuizController_putTeam73_invoker.call(quiz.QuizController.putTeam())
   }
}
        

// @LINE:111
case quiz_QuizController_deleteTeamById74_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        quiz_QuizController_deleteTeamById74_invoker.call(quiz.QuizController.deleteTeamById(id))
   }
}
        

// @LINE:112
case quiz_QuizController_quizSeasons75_route(params) => {
   call { 
        quiz_QuizController_quizSeasons75_invoker.call(quiz.QuizController.quizSeasons())
   }
}
        

// @LINE:113
case quiz_QuizController_putSeason76_route(params) => {
   call { 
        quiz_QuizController_putSeason76_invoker.call(quiz.QuizController.putSeason())
   }
}
        

// @LINE:114
case quiz_QuizController_deleteSeasonById77_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        quiz_QuizController_deleteSeasonById77_invoker.call(quiz.QuizController.deleteSeasonById(id))
   }
}
        

// @LINE:117
case rfid_RFIDReader_index78_route(params) => {
   call { 
        rfid_RFIDReader_index78_invoker.call(rfid.RFIDReader.index())
   }
}
        

// @LINE:118
case rfid_RFIDReader_indexContinue79_route(params) => {
   call(params.fromPath[String]("status", None), params.fromPath[String]("number", None), params.fromQuery[String]("eventId", None)) { (status, number, eventId) =>
        rfid_RFIDReader_indexContinue79_invoker.call(rfid.RFIDReader.indexContinue(status, number, eventId))
   }
}
        

// @LINE:119
case rfid_RFIDReader_read80_route(params) => {
   call { 
        rfid_RFIDReader_read80_invoker.call(rfid.RFIDReader.read())
   }
}
        

// @LINE:122
case renders_Search_search81_route(params) => {
   call(params.fromQuery[String]("term", Some("")), params.fromQuery[Int]("page", Some(0))) { (term, page) =>
        renders_Search_search81_invoker.call(renders.Search.search(term, page))
   }
}
        

// @LINE:125
case timeline_Timeline_index82_route(params) => {
   call { 
        timeline_Timeline_index82_invoker.call(timeline.Timeline.index())
   }
}
        

// @LINE:128
case update_Update_index83_route(params) => {
   call { 
        update_Update_index83_invoker.call(update.Update.index())
   }
}
        

// @LINE:129
case update_Update_utgaver84_route(params) => {
   call { 
        update_Update_utgaver84_invoker.call(update.Update.utgaver())
   }
}
        

// @LINE:130
case update_Update_redaksjon85_route(params) => {
   call { 
        update_Update_redaksjon85_invoker.call(update.Update.redaksjon())
   }
}
        

// @LINE:133
case ballot_VoteController_lazyRedirect86_route(params) => {
   call { 
        ballot_VoteController_lazyRedirect86_invoker.call(ballot.VoteController.lazyRedirect())
   }
}
        

// @LINE:134
case ballot_VoteController_lazyRedirect87_route(params) => {
   call { 
        ballot_VoteController_lazyRedirect87_invoker.call(ballot.VoteController.lazyRedirect())
   }
}
        

// @LINE:135
case ballot_VoteController_index88_route(params) => {
   call { 
        ballot_VoteController_index88_invoker.call(ballot.VoteController.index())
   }
}
        

// @LINE:136
case ballot_VoteController_attemptVote89_route(params) => {
   call { 
        ballot_VoteController_attemptVote89_invoker.call(ballot.VoteController.attemptVote())
   }
}
        

// @LINE:137
case ballot_VoteController_getChoices90_route(params) => {
   call { 
        ballot_VoteController_getChoices90_invoker.call(ballot.VoteController.getChoices)
   }
}
        

// @LINE:138
case ballot_VoteController_overview91_route(params) => {
   call { 
        ballot_VoteController_overview91_invoker.call(ballot.VoteController.overview())
   }
}
        

// @LINE:139
case ballot_VoteController_newBallot92_route(params) => {
   call { 
        ballot_VoteController_newBallot92_invoker.call(ballot.VoteController.newBallot())
   }
}
        

// @LINE:140
case ballot_VoteController_getResults93_route(params) => {
   call { 
        ballot_VoteController_getResults93_invoker.call(ballot.VoteController.getResults)
   }
}
        

// @LINE:144
case backup_BackupDatabase_index94_route(params) => {
   call { 
        backup_BackupDatabase_index94_invoker.call(backup.BackupDatabase.index())
   }
}
        

// @LINE:147
case controllers_Upload_ajaxUpload95_route(params) => {
   call { 
        controllers_Upload_ajaxUpload95_invoker.call(controllers.Upload.ajaxUpload())
   }
}
        

// @LINE:148
case controllers_Upload_ajaxUploadTo96_route(params) => {
   call(params.fromPath[String]("uploadFolder", None)) { (uploadFolder) =>
        controllers_Upload_ajaxUploadTo96_invoker.call(controllers.Upload.ajaxUploadTo(uploadFolder))
   }
}
        

// @LINE:152
case chat_Chat_connectClient97_route(params) => {
   call { 
        chat_Chat_connectClient97_invoker.call(chat.Chat.connectClient())
   }
}
        

// @LINE:153
case chat_Chat_socket98_route(params) => {
   call { 
        chat_Chat_socket98_invoker.call(chat.Chat.socket())
   }
}
        

// @LINE:157
case examples_controllers_ExampleEbean_index99_route(params) => {
   call { 
        examples_controllers_ExampleEbean_index99_invoker.call(examples.controllers.ExampleEbean.index())
   }
}
        

// @LINE:158
case examples_controllers_ExampleEbean_add100_route(params) => {
   call { 
        examples_controllers_ExampleEbean_add100_invoker.call(examples.controllers.ExampleEbean.add())
   }
}
        

// @LINE:159
case examples_controllers_ExampleEbean_clear101_route(params) => {
   call { 
        examples_controllers_ExampleEbean_clear101_invoker.call(examples.controllers.ExampleEbean.clear())
   }
}
        

// @LINE:161
case examples_controllers_ExampleImageUpload_index102_route(params) => {
   call { 
        examples_controllers_ExampleImageUpload_index102_invoker.call(examples.controllers.ExampleImageUpload.index())
   }
}
        

// @LINE:162
case examples_controllers_ExampleImageUpload_upload103_route(params) => {
   call { 
        examples_controllers_ExampleImageUpload_upload103_invoker.call(examples.controllers.ExampleImageUpload.upload())
   }
}
        

// @LINE:164
case examples_controllers_ExampleCookies_index104_route(params) => {
   call { 
        examples_controllers_ExampleCookies_index104_invoker.call(examples.controllers.ExampleCookies.index())
   }
}
        

// @LINE:165
case examples_controllers_ExampleCookies_clearAllCookies105_route(params) => {
   call { 
        examples_controllers_ExampleCookies_clearAllCookies105_invoker.call(examples.controllers.ExampleCookies.clearAllCookies())
   }
}
        

// @LINE:166
case examples_controllers_ExampleCookies_clearAllCookies106_route(params) => {
   call { 
        examples_controllers_ExampleCookies_clearAllCookies106_invoker.call(examples.controllers.ExampleCookies.clearAllCookies())
   }
}
        

// @LINE:168
case examples_controllers_ExampleDatabase_index107_route(params) => {
   call { 
        examples_controllers_ExampleDatabase_index107_invoker.call(examples.controllers.ExampleDatabase.index())
   }
}
        

// @LINE:170
case examples_controllers_ExampleAngular_index108_route(params) => {
   call { 
        examples_controllers_ExampleAngular_index108_invoker.call(examples.controllers.ExampleAngular.index())
   }
}
        

// @LINE:172
case examples_controllers_ExampleStaticAccess_index109_route(params) => {
   call { 
        examples_controllers_ExampleStaticAccess_index109_invoker.call(examples.controllers.ExampleStaticAccess.index())
   }
}
        

// @LINE:175
case redir_Redir_artikler110_route(params) => {
   call(params.fromPath[String]("path", None)) { (path) =>
        redir_Redir_artikler110_invoker.call(redir.Redir.artikler(path))
   }
}
        

// @LINE:176
case redir_Redir_nyheter111_route(params) => {
   call { 
        redir_Redir_nyheter111_invoker.call(redir.Redir.nyheter())
   }
}
        

// @LINE:179
case controllers_Assets_at112_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at112_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:181
case controllers_Restricted_at113_route(params) => {
   call(params.fromPath[String]("restriction", None), params.fromPath[String]("file", None)) { (restriction, file) =>
        controllers_Restricted_at113_invoker.call(controllers.Restricted.at(restriction, file))
   }
}
        

// @LINE:184
case application_Application_showUnauthorizedAccess114_route(params) => {
   call { 
        application_Application_showUnauthorizedAccess114_invoker.call(application.Application.showUnauthorizedAccess())
   }
}
        

// @LINE:187
case application_Application_show400115_route(params) => {
   call(params.fromPath[String]("error", None)) { (error) =>
        application_Application_show400115_invoker.call(application.Application.show400(error))
   }
}
        

// @LINE:188
case application_Application_show404116_route(params) => {
   call(params.fromPath[String]("anything", None)) { (anything) =>
        application_Application_show404116_invoker.call(application.Application.show404(anything))
   }
}
        
}

}
     