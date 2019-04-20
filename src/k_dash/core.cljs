(ns k-dash.core
    (:require-macros [k-dash.macros :refer [read-json]])
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "This text is printed from src/k-dash/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defn learning-ko []
 [:div 
  [:section {:class "hero is-success is-bold"}
   [:div.hero-body
    [:div.container
      [:h1.title "Learning Korean"]
      [:br]
      [:a {:class "is-link subtitle" :href "https://krdict.korean.go.kr/eng/smallDic/mainAction?nationCode=6"} "Translator"]
      [:br]  
      [:a {:class "subtitle is-link" :href "https://www.youtube.com/watch?v=H5aKdql4wHE&list=PLDnd3kXHGLJj1cchLH7v84vVQMV7S_DGq&index=1"} "K-Dramas"]]]]])

(defn about []
 [:div 
  [:section {:class "hero is-primary is-bold"}
   [:div.hero-body
    [:div.container
      [:h1.title "About"]
      [:li [:a {:class "is-link subtitle " :href "https://conniepocky.github.io/"} "Creator Website"]]
      [:hr]
      [:li [:a {:class "is-link subtitle " :href "https://github.com/conniepocky/k-dash"} "GitHub Repository"]]]]]])

(defn mv-card [info]
  (def title (get info "title")) 
  (def link (get info "link"))
  [:div {:class "box"}
       [:h1 {:class "title"} title] 
       [:iframe {:src link
                 :allow-full-screen "allowfullscreen"
                  :frame-border 0
                  :auto-play 1}]])

(defn group-card [info is-mv]
  (def members (get info "members"))
  (def img (get info "img"))
  (def n (get info "name")) 
  [:div {:class "box"}
    [:h1 {:class "title"} n]
    [:img {:src img}]
    [:h3.subtitle "Member"]
    [:li members]])

(defn groups []
 [:div
  [:section {:class "hero is-light is-bold"}
   [:div.hero-body
    [:div.container
        [:h1.title "Groups"]
        [group-card (rand-nth (get (read-json "info.json") "groups"))]
        [:br]
        [group-card (rand-nth (get (read-json "info.json") "groups"))] 
        [:br]
        [group-card (rand-nth (get (read-json "info.json") "groups"))]
        [:br {:id "mvs"}]
        [:br]
        [:div.box 
          [:h3.title [:a {:href "https://github.com/conniepocky/k-dash/issues"} "Click this link to request a group to be added."]]]
        [:br]]]]])
 
(defn mv []
  [:div] 
  [:section {:class "hero is-warning is-bold"}
   [:div.hero-body
    [:div.container
      [:h1.title "Music Videos"]
      [:br]
      [mv-card (rand-nth (get (read-json "info.json") "mvs"))] 
      [mv-card (rand-nth (get (read-json "info.json") "mvs"))] 
      [mv-card (rand-nth (get (read-json "info.json") "mvs"))] 
      [mv-card (rand-nth (get (read-json "info.json") "mvs"))] 
      [mv-card (rand-nth (get (read-json "info.json") "mvs"))] 
      [mv-card (rand-nth (get (read-json "info.json") "mvs"))]]]]) 

(defn hello-world []
 [:div
  [:section {:class "hero is-info is-bold navbar is-fixed-top"}
      [:div.hero-body
        [:div.container
           [:h1.title "K-Dash!"]
           [:h3.subtitle "The ultimiate dashboard for all Koreaboos and K-Pop fans!"]
           [:nav {:class "breadcrumb" :aria-label "breadcrumbs"}
              [:ul
                [:li [:a {:href "#top"} "About"]]
                [:li [:a {:href "#learn-ko"} "Learning Korean"]]
                [:li [:a {:href "#group"} "Groups"]]
                [:li [:a {:href "#mvs"} "M/V"]]]]]]]
  ;;Adding Space
  [:br]
  [:br]
  [:br]
  [:br]
  [:br]
  [:br]
  [:br]
  [:br]
  [:br]
  [:br {:id "learn-ko"}]
  ;;Add About Card
  [about]
  ;;Add Learning Korean Card
  [:br {:id "group"}]
  [learning-ko]
  ;;Add Group Cards
  [:br]
  [groups]
  ;;Add MV Cards
  [:br]
  [:br]
  [:br]
  [:br]
  [:br]
  [mv]])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload [])

