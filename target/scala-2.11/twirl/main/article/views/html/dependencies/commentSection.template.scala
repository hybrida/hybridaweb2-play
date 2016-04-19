
package article.views.html.dependencies

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
object commentSection extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Article,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(inarticle: Article):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.22*/("""
"""),format.raw/*2.1*/("""<div class="transparent-box comment-section">
    <h6 class="top-text">Kommentarer</h6>
    """),_display_(/*4.6*/for(c <- inarticle.getCommentList) yield /*4.40*/{_display_(Seq[Any](format.raw/*4.41*/("""
        """),format.raw/*5.9*/("""<div class="row">
            <div class="col-xs-2 col-lg-2" style="padding-right:0">
                """),_display_(/*7.18*/c/*7.19*/.getAuthor.getThumbnail),format.raw/*7.42*/("""
            """),format.raw/*8.13*/("""</div>
            <div class="col-xs-10 col-lg-10" style="padding-left:2.5%">
                <div class="row">
                    <div class="col-xs-11">
                        <strong>"""),_display_(/*12.34*/{c.getAuthor.getNameLink}),format.raw/*12.59*/(""":</strong>
                    </div>
                    <div class="col-xs-1" style="padding-left: 0;">
                        """),_display_(/*15.26*/if(c.getAuthor.equals(models.LoginState.getUser) || c.getAuthor.admin)/*15.96*/{_display_(Seq[Any](format.raw/*15.97*/("""
                            """),format.raw/*16.29*/("""<div class="btn-group pull-right">
                                <button class="btn btn-default btn-xs dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-right" role="menu" style="min-width:0;padding:0;border:none;">
                                    <form method="POST" action=""""),_display_(/*21.66*/article/*21.73*/.routes.Article.deleteComment(c.getCommentID.toString)),format.raw/*21.127*/("""">
                                        <button type="submit" class="btn btn-sm btn-danger"> Slett </button>
                                    </form>
                                </ul>
                            </div>
                        """)))}),format.raw/*26.26*/("""
                    """),format.raw/*27.21*/("""</div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        """),_display_(/*31.26*/(c.getComment)),format.raw/*31.40*/("""
                    """),format.raw/*32.21*/("""</div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <small> """),_display_(/*36.34*/c/*36.35*/.getTimestamp),format.raw/*36.48*/(""" """),format.raw/*36.49*/("""</small>
                    </div>
                </div>
            </div>
        </div>
    """)))}),format.raw/*41.6*/("""
    """),format.raw/*42.5*/("""<div style="margin-top:1em">
        <form action=""""),_display_(/*43.24*/article/*43.31*/.routes.Article.comment(inarticle.getId.toString)),format.raw/*43.80*/("""" method="POST">
            <label for="comment" class="sr-only">Comment:</label>
            <div class="input-group">
                <input type="text" class="form-control" id="comment" name="comment" autocomplete="off" maxlength="250">
                <span class="input-group-btn">
                    <button type="submit" class="btn btn-primary">Kommenter</button>
                </span>
            </div>
        </form>
    </div>
</div>"""))}
  }

  def render(inarticle:Article): play.twirl.api.HtmlFormat.Appendable = apply(inarticle)

  def f:((Article) => play.twirl.api.HtmlFormat.Appendable) = (inarticle) => apply(inarticle)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/dependencies/commentSection.scala.html
                  HASH: 969a1c748fe026712d5f0bd21f52adbf87fb473c
                  MATRIX: 754->1|862->21|890->23|1010->118|1059->152|1097->153|1133->163|1264->268|1273->269|1316->292|1357->306|1578->500|1624->525|1785->659|1864->729|1903->730|1961->760|2480->1252|2496->1259|2572->1313|2862->1572|2912->1594|3076->1731|3111->1745|3161->1767|3333->1912|3343->1913|3377->1926|3406->1927|3539->2030|3572->2036|3652->2089|3668->2096|3738->2145
                  LINES: 26->1|29->1|30->2|32->4|32->4|32->4|33->5|35->7|35->7|35->7|36->8|40->12|40->12|43->15|43->15|43->15|44->16|49->21|49->21|49->21|54->26|55->27|59->31|59->31|60->32|64->36|64->36|64->36|64->36|69->41|70->42|71->43|71->43|71->43
                  -- GENERATED --
              */
          