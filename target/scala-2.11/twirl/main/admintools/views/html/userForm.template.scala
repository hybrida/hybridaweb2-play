
package admintools.views.html

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
import profile.models.User
import util._
/**/
object userForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[User,Boolean,Long,Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(user: User, showTitles: Boolean, uid: Long, rootAccess: Boolean):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*3.67*/("""
"""),_display_(/*4.2*/if(showTitles)/*4.16*/{_display_(Seq[Any](format.raw/*4.17*/("""<hr>
<div style="display: table-row">
	<div style="display: table-cell"> Id </div>
	<div style="display: table-cell"> Link </div>
"""),format.raw/*8.58*/("""
	"""),format.raw/*9.2*/("""<div style="display: table-cell"> Arrkom </div>
	<div style="display: table-cell"> Medlem </div>
	<div style="display: table-cell"> Jentekom </div>
	<div style="display: table-cell"> Redaksjon </div>
	<div style="display: table-cell"> Bedkom </div>
	<div style="display: table-cell"> Vevkom </div>
	"""),_display_(/*15.3*/if(rootAccess)/*15.17*/ {_display_(Seq[Any](format.raw/*15.19*/("""
			"""),format.raw/*16.4*/("""<div style="display: table-cell"> Admin </div>
	""")))}),format.raw/*17.3*/("""
	"""),format.raw/*18.2*/("""<div style="display: table-cell"> Kjønn </div>
	<div style="display: table-cell"> Avgangsår </div>
	<div style="display: table-cell"> </div>
	"""),_display_(/*21.3*/if(rootAccess)/*21.17*/ {_display_(Seq[Any](format.raw/*21.19*/("""
		"""),format.raw/*22.3*/("""<div style="display: table-cell"> </div>
	""")))}),format.raw/*23.3*/("""
"""),format.raw/*24.1*/("""</div>
""")))}),format.raw/*25.2*/("""
"""),format.raw/*26.1*/("""<div style="display: table-row">
	<div style="display: table-cell">
		"""),_display_(/*28.4*/uid),format.raw/*28.7*/("""
	"""),format.raw/*29.2*/("""</div>
	<div style="display: table-cell">
		<a href=""""),_display_(/*31.13*/profile/*31.20*/.routes.Profile.index(user.getUsername)),format.raw/*31.59*/("""">"""),_display_(/*31.62*/user/*31.66*/.getUsername),format.raw/*31.78*/("""</a>
	</div>
"""),format.raw/*35.11*/("""
	"""),format.raw/*36.2*/("""<div style="display: table-cell">
		<input type="checkbox" name="arrkom" form="form_"""),_display_(/*37.52*/uid),format.raw/*37.55*/("""" """),_display_(/*37.58*/TextUtil/*37.66*/.bool2checked(user.isInArrkom)),format.raw/*37.96*/(""">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="member" form="form_"""),_display_(/*40.52*/uid),format.raw/*40.55*/("""" """),_display_(/*40.58*/TextUtil/*40.66*/.bool2checked(user.isMember)),format.raw/*40.94*/(""">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="jentekom" form="form_"""),_display_(/*43.54*/uid),format.raw/*43.57*/("""" """),_display_(/*43.60*/TextUtil/*43.68*/.bool2checked(user.isInJentekom)),format.raw/*43.100*/(""">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="redaksjonen" form="form_"""),_display_(/*46.57*/uid),format.raw/*46.60*/("""" """),_display_(/*46.63*/TextUtil/*46.71*/.bool2checked(user.isInRedaksjonen)),format.raw/*46.106*/(""">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="bedkom" form="form_"""),_display_(/*49.52*/uid),format.raw/*49.55*/("""" """),_display_(/*49.58*/TextUtil/*49.66*/.bool2checked(user.isInBedkom)),format.raw/*49.96*/(""">
	</div>
	<div style="display: table-cell">
		<input type="checkbox" name="vevkom" form="form_"""),_display_(/*52.52*/uid),format.raw/*52.55*/("""" """),_display_(/*52.58*/TextUtil/*52.66*/.bool2checked(user.isInVevkom)),format.raw/*52.96*/(""">
	</div>
    """),_display_(/*54.6*/if(rootAccess)/*54.20*/{_display_(Seq[Any](format.raw/*54.21*/("""
        """),format.raw/*55.9*/("""<div style="display: table-cell">
            <input type="checkbox" name="admin" form="form_"""),_display_(/*56.61*/uid),format.raw/*56.64*/("""" """),_display_(/*56.67*/TextUtil/*56.75*/.bool2checked(user.isAdmin)),format.raw/*56.102*/(""">
        </div>
    """)))}),format.raw/*58.6*/("""
	"""),format.raw/*59.2*/("""<div style="display: table-cell">
		<select class="form-control" name="gender" form="form_"""),_display_(/*60.58*/uid),format.raw/*60.61*/("""">
			<option value="U" """),_display_(/*61.23*/TextUtil/*61.31*/.bool2selected(user.isUnknownGender)),format.raw/*61.67*/(""">Ikke satt</option>
			<option value="M" """),_display_(/*62.23*/TextUtil/*62.31*/.bool2selected(user.isMale)),format.raw/*62.58*/(""">Mann</option>
			<option value="F" """),_display_(/*63.23*/TextUtil/*63.31*/.bool2selected(user.isFemale)),format.raw/*63.60*/(""">Kvinne</option>
		</select>
	</div>
	<div style="display: table-cell">
		<input class="form-control" type="text" name="graduationYear" form="form_"""),_display_(/*67.77*/uid),format.raw/*67.80*/("""" value=""""),_display_(/*67.90*/user/*67.94*/.getGraduationYear),format.raw/*67.112*/("""">
	</div>
	<div style="display: table-cell">
		<input class="btn btn-primary" type="submit" form="form_"""),_display_(/*70.60*/uid),format.raw/*70.63*/("""">
	</div>
    """),_display_(/*72.6*/if(rootAccess)/*72.20*/ {_display_(Seq[Any](format.raw/*72.22*/("""
        """),format.raw/*73.9*/("""<div style="display: table-cell">
            <button class="btn btn-danger" type="submit" name="delete" form="form_"""),_display_(/*74.84*/uid),format.raw/*74.87*/("""">
                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
            </button>
        </div>
    """)))}),format.raw/*78.6*/("""
"""),format.raw/*79.1*/("""</div>
"""))}
  }

  def render(user:User,showTitles:Boolean,uid:Long,rootAccess:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(user,showTitles,uid,rootAccess)

  def f:((User,Boolean,Long,Boolean) => play.twirl.api.HtmlFormat.Appendable) = (user,showTitles,uid,rootAccess) => apply(user,showTitles,uid,rootAccess)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/admintools/views/userForm.scala.html
                  HASH: e24a4bca0d96ebdc685202e556e4705865ab572c
                  MATRIX: 796->46|949->111|977->114|999->128|1037->129|1198->320|1227->323|1559->629|1582->643|1622->645|1654->650|1734->700|1764->703|1936->849|1959->863|1999->865|2030->869|2104->913|2133->915|2172->924|2201->926|2300->999|2323->1002|2353->1005|2436->1061|2452->1068|2512->1107|2542->1110|2555->1114|2588->1126|2631->1292|2661->1295|2774->1381|2798->1384|2828->1387|2845->1395|2896->1425|3022->1524|3046->1527|3076->1530|3093->1538|3142->1566|3270->1667|3294->1670|3324->1673|3341->1681|3395->1713|3526->1817|3550->1820|3580->1823|3597->1831|3654->1866|3780->1965|3804->1968|3834->1971|3851->1979|3902->2009|4028->2108|4052->2111|4082->2114|4099->2122|4150->2152|4193->2169|4216->2183|4255->2184|4292->2194|4414->2289|4438->2292|4468->2295|4485->2303|4534->2330|4588->2354|4618->2357|4737->2449|4761->2452|4814->2478|4831->2486|4888->2522|4958->2565|4975->2573|5023->2600|5088->2638|5105->2646|5155->2675|5334->2827|5358->2830|5395->2840|5408->2844|5448->2862|5583->2970|5607->2973|5651->2991|5674->3005|5714->3007|5751->3017|5896->3135|5920->3138|6082->3270|6111->3272
                  LINES: 27->3|30->3|31->4|31->4|31->4|35->8|36->9|42->15|42->15|42->15|43->16|44->17|45->18|48->21|48->21|48->21|49->22|50->23|51->24|52->25|53->26|55->28|55->28|56->29|58->31|58->31|58->31|58->31|58->31|58->31|60->35|61->36|62->37|62->37|62->37|62->37|62->37|65->40|65->40|65->40|65->40|65->40|68->43|68->43|68->43|68->43|68->43|71->46|71->46|71->46|71->46|71->46|74->49|74->49|74->49|74->49|74->49|77->52|77->52|77->52|77->52|77->52|79->54|79->54|79->54|80->55|81->56|81->56|81->56|81->56|81->56|83->58|84->59|85->60|85->60|86->61|86->61|86->61|87->62|87->62|87->62|88->63|88->63|88->63|92->67|92->67|92->67|92->67|92->67|95->70|95->70|97->72|97->72|97->72|98->73|99->74|99->74|103->78|104->79
                  -- GENERATED --
              */
          