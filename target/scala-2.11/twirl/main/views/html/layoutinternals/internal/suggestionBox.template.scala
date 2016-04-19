
package views.html.layoutinternals.internal

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

/**/
object suggestionBox extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<div id="suggestionBox" class="white-box fixed-bottom-right" style="padding: 0 30px 20px">
    <input id="suggestingUser" value=""""),_display_(/*4.40*/if(models.LoginState.isValidlyLoggedIn())/*4.81*/{_display_(Seq[Any](_display_(/*4.83*/models/*4.89*/.LoginState.getUser().getFullName()),format.raw/*4.124*/(""" """),format.raw/*4.125*/("""("""),_display_(/*4.127*/if(models.LoginState.getUser().getEmail()=="")/*4.173*/{_display_(Seq[Any](_display_(/*4.175*/models/*4.181*/.LoginState.getUser().getUsername()),format.raw/*4.216*/("""@stud.ntnu.no""")))}/*4.231*/else/*4.235*/{_display_(_display_(/*4.237*/models/*4.243*/.LoginState.getUser().getEmail()))}),format.raw/*4.276*/(""")""")))}),format.raw/*4.278*/("""" hidden>
    <h2 style="text-align: center">Forslag til Vevkom</h2>
    <div class="form-group">
        <!--<label for="suggestionContent">Forslag til forbedring</label>-->
        <textarea class="form-control" rows="10" cols="50" id="suggestionContent" style="resize: none" placeholder="Gi oss ros eller ris, vi tar det med et glis!"></textarea>
        <input type="checkbox" id="suggestAnonymously"> Send anonymt
    </div>
    <button type="submit" class="btn btn-primary form-control" id="suggestionButton" onclick="submitSuggestion()">Send</button>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:37:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/layoutinternals/internal/suggestionBox.scala.html
                  HASH: 8e1dc3b363229383bee6da1bcc83de2e96197640
                  MATRIX: 749->1|838->3|868->7|1025->138|1074->179|1112->181|1126->187|1182->222|1211->223|1240->225|1295->271|1334->273|1349->279|1405->314|1438->329|1451->333|1481->335|1496->341|1552->374|1585->376
                  LINES: 26->1|29->1|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4
                  -- GENERATED --
              */
          