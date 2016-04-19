
package quiz.views.html

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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div ng-app="quiz" class="quiz-container">
    <div ng-controller="tabController as tabCtrl">
        <ul class="nav nav-tabs quiz-tabs">
            <li role="presentation" ng-class=""""),format.raw/*4.47*/("""{"""),format.raw/*4.48*/("""active: tabCtrl.currentTab === 'hybQuizOverview' """),format.raw/*4.97*/("""}"""),format.raw/*4.98*/("""">
                <a href ng-click="tabCtrl.currentTab = 'hybQuizOverview'">Oversikt</a>
            </li>
            <li role="presentation" ng-class=""""),format.raw/*7.47*/("""{"""),format.raw/*7.48*/("""active: tabCtrl.currentTab === 'hybQuizViewer' """),format.raw/*7.95*/("""}"""),format.raw/*7.96*/("""">
                <a href ng-click="tabCtrl.currentTab = 'hybQuizViewer'">Quiz</a>
            </li>
            <li role="presentation" ng-class=""""),format.raw/*10.47*/("""{"""),format.raw/*10.48*/("""active: tabCtrl.currentTab === 'hybQuizSeason' """),format.raw/*10.95*/("""}"""),format.raw/*10.96*/("""">
                <a href ng-click="tabCtrl.currentTab = 'hybQuizSeason'">Sesonger</a>
            </li>
            <li role="presentation" ng-class=""""),format.raw/*13.47*/("""{"""),format.raw/*13.48*/("""active: tabCtrl.currentTab === 'hybQuizTeams' """),format.raw/*13.94*/("""}"""),format.raw/*13.95*/("""">
                <a href ng-click="tabCtrl.currentTab = 'hybQuizTeams'">Quizlag</a>
            </li>
        </ul>

        <hyb-quiz-overview ng-show="tabCtrl.currentTab === 'hybQuizOverview'"></hyb-quiz-overview>
        <hyb-quiz-viewer ng-show="tabCtrl.currentTab === 'hybQuizViewer'"></hyb-quiz-viewer>
        <hyb-quiz-season ng-show="tabCtrl.currentTab === 'hybQuizSeason'"></hyb-quiz-season>
        <hyb-quiz-teams ng-show="tabCtrl.currentTab === 'hybQuizTeams'"></hyb-quiz-teams>
    </div>
</div>

<script src=""""),_display_(/*25.15*/routes/*25.21*/.Assets.at("angular/angular.min.js")),format.raw/*25.57*/(""""></script>
<script src=""""),_display_(/*26.15*/routes/*26.21*/.Assets.at("javascripts/quiz.js")),format.raw/*26.54*/(""""></script>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/quiz/views/index.scala.html
                  HASH: 37ee705fd1a5dc38a844697d5cc43e7eb03e40e8
                  MATRIX: 803->0|1017->187|1045->188|1121->237|1149->238|1333->395|1361->396|1435->443|1463->444|1642->595|1671->596|1746->643|1775->644|1958->799|1987->800|2061->846|2090->847|2656->1386|2671->1392|2728->1428|2782->1455|2797->1461|2851->1494
                  LINES: 29->1|32->4|32->4|32->4|32->4|35->7|35->7|35->7|35->7|38->10|38->10|38->10|38->10|41->13|41->13|41->13|41->13|53->25|53->25|53->25|54->26|54->26|54->26
                  -- GENERATED --
              */
          