
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
object articleSection extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Article,Revisable[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: CRUDable
},play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(inarticle: Article, revisable: Revisable[_ <: CRUDable]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.59*/("""

"""),_display_(/*3.2*/if(inarticle.getImagePath != null)/*3.36*/ {_display_(Seq[Any](format.raw/*3.38*/("""
    """),format.raw/*4.5*/("""<img src=""""),_display_(/*4.16*/inarticle/*4.25*/.getImagePath),format.raw/*4.38*/("""" class="center-block img-responsive art-img">
""")))}),format.raw/*5.2*/("""
"""),format.raw/*6.1*/("""<h1>"""),_display_(/*6.6*/inarticle/*6.15*/.getTitle),format.raw/*6.24*/("""</h1>
<h3><p class="text-center">"""),_display_(/*7.29*/inarticle/*7.38*/.getIngress),format.raw/*7.49*/("""</p></h3>
<h6 class="top-text">
    Av: """),_display_(/*9.10*/inarticle/*9.19*/.getAuthor.getNameLink),format.raw/*9.41*/("""
    """),_display_(/*10.6*/if(models.LoginState.getUser().getUsername == inarticle.getAuthor.getUsername || LoginState.getUser.isAdmin)/*10.114*/ {_display_(Seq[Any](format.raw/*10.116*/("""
        """),format.raw/*11.9*/("""<a class="pull-right" href=""""),_display_(/*11.38*/revisable/*11.47*/.getUpdateCall),format.raw/*11.61*/("""">
            <button class="btn btn-xs btn-primary"> Rediger </button>
        </a>
    """)))}),format.raw/*14.6*/("""
    """),_display_(/*15.6*/if(revisable.hasPrevious)/*15.31*/{_display_(Seq[Any](format.raw/*15.32*/("""
        """),format.raw/*16.9*/("""<a href=""""),_display_(/*16.19*/revisable/*16.28*/.getPrevious.getReadCall),format.raw/*16.52*/("""">
            Tidligere revisjon
        </a>
    """)))}),format.raw/*19.6*/("""
"""),format.raw/*20.1*/("""</h6>
<p class="text-center">"""),_display_(/*21.25*/Html(inarticle.getText)),format.raw/*21.48*/("""</p>"""))}
  }

  def render(inarticle:Article,revisable:Revisable[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: CRUDable
}): play.twirl.api.HtmlFormat.Appendable = apply(inarticle,revisable)

  def f:((Article,Revisable[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: CRUDable
}) => play.twirl.api.HtmlFormat.Appendable) = (inarticle,revisable) => apply(inarticle,revisable)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/dependencies/articleSection.scala.html
                  HASH: c2768006335db35d113e94212595e2e6ecb72fb2
                  MATRIX: 832->1|977->58|1007->63|1049->97|1088->99|1120->105|1157->116|1174->125|1207->138|1285->187|1313->189|1343->194|1360->203|1389->212|1450->247|1467->256|1498->267|1567->310|1584->319|1626->341|1659->348|1777->456|1818->458|1855->468|1911->497|1929->506|1964->520|2088->614|2121->621|2155->646|2194->647|2231->657|2268->667|2286->676|2331->700|2416->755|2445->757|2503->788|2547->811
                  LINES: 28->1|31->1|33->3|33->3|33->3|34->4|34->4|34->4|34->4|35->5|36->6|36->6|36->6|36->6|37->7|37->7|37->7|39->9|39->9|39->9|40->10|40->10|40->10|41->11|41->11|41->11|41->11|44->14|45->15|45->15|45->15|46->16|46->16|46->16|46->16|49->19|50->20|51->21|51->21
                  -- GENERATED --
              */
          