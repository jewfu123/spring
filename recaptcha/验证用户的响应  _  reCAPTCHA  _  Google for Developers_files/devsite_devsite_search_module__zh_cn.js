(function(_ds){var window=this;var Gea=function(a){return(0,_ds.R)('<div class="devsite-popout" id="'+_ds.X(a.id)+'"><div class="devsite-popout-result devsite-suggest-results-container" devsite-hide></div></div>')},i7=function(a){a=_ds.S(a)+"\u4e2d\u7684\u6240\u6709\u7ed3\u679c";return(0,_ds.R)('<button type="submit" class="button button-white devsite-search-project-scope">'+a+"</button>")},j7=function(a,b,c){let d='<button type="submit" class="button button-white devsite-suggest-all-results">';b?(a=_ds.S(c)+"\u4e2d\u7684\u6240\u6709\u7ed3\u679c",
d+=a):(a="\u201c"+_ds.S(a)+"\u201d\u7684\u6240\u6709\u7ed3\u679c",d+=a);return(0,_ds.R)(d+"</button>")},k7=function(a,b,c,d,e,f,g,h){a=(c?"":'<devsite-analytics-scope action="'+_ds.X(_ds.Z("Restricted "+d))+'">')+'<a class="devsite-result-item-link" href="'+_ds.X(_ds.Z(a))+'"><span class="devsite-suggestion-fragment">'+_ds.S(b)+"</span>"+(h?'<span class="devsite-suggestion-fragment">'+_ds.S(h)+"</span>":"")+(e?'<span class="devsite-suggestion-fragment">'+_ds.S(e)+"</span>":"")+(_ds.rH(f)&&!g?'<span class="devsite-suggestion-fragment">'+
_ds.S(f)+"</span>":"");c||(a+='<span class="devsite-result-item-confidential">\u673a\u5bc6</span>');return(0,_ds.R)(a+("</a>"+(c?"":"</devsite-analytics-scope>")))},Hea=function(a){var b=a.projectName;const c=a.Tq,d=a.query,e=a.Yq;a=a.zk;b='<div class="devsite-suggest-wrapper '+(e?"":"devsite-search-disabled")+'"><div class="devsite-suggest-section"><div class="devsite-result-label">\u6ca1\u6709\u4e0e\u60a8\u7684\u67e5\u8be2\u76f8\u5173\u7684\u5efa\u8bae</div></div>'+((e?'<div class="devsite-suggest-footer">'+
(c?i7(b):"")+j7(d,c,a)+"</div>":"")+"</div>");return(0,_ds.R)(b)},Iea=function(a){var b=a.Ow;const c=a.Xw;var d=a.hx;const e=a.projectName,f=a.Tq,g=a.query;var h=a.mx;const k=a.Yq;a=a.zk;let l='<div class="devsite-suggest-wrapper '+(k?"":"devsite-search-disabled")+'" tabindex="0" role="list"><div class="devsite-suggest-section">';if(0<_ds.T(d).length){l=l+'<div class="devsite-suggest-sub-section" role="listitem"><div class="devsite-suggest-header" id="devsite-suggest-header-partial-query" role="heading" aria-level="2">\u5efa\u8bae\u7684\u641c\u7d22'+
((f?'<span class="devsite-suggest-project">'+_ds.S(e)+"</span>":"")+'</div><devsite-analytics-scope category="Site-Wide Custom Events" label="Search" role="list" aria-labelledby="devsite-suggest-header-partial-query" action="Query Suggestion Click">');var m=d.length;for(var n=0;n<m;n++){var q=d[n];l+='<div class="devsite-result-item devsite-nav-label" id="suggestion-partial-query-'+_ds.X(n)+'" role="listitem" index=":'+_ds.X(n)+'">'+k7(q.getPath(),q.getTitle(),_ds.hg(q,14),"Query Suggestion Click")+
"</div>"}l+="</devsite-analytics-scope></div>"}l+=0<_ds.T(d).length&&0<_ds.T(b).length?'<hr role="none">':"";if(0<_ds.T(b).length){l=l+'<div class="devsite-suggest-sub-section" role="listitem"><div class="devsite-suggest-header" id="devsite-suggest-header-product" role="heading" aria-level="2">\u9875\u9762'+((f?'<span class="devsite-suggest-project">'+_ds.S(e)+"</span>":"")+'</div><devsite-analytics-scope category="Site-Wide Custom Events" label="Search" role="list" aria-labelledby="devsite-suggest-header-product" action="Page Suggestion Click">');
m=b.length;for(n=0;n<m;n++)q=b[n],l+='<div class="devsite-result-item devsite-nav-label" id="suggestion-product-'+_ds.X(n)+'" role="listitem" index=":'+_ds.X(n)+'">'+k7(q.getPath(),q.getTitle(),_ds.hg(q,14),"Page Suggestion Click",void 0,_ds.z(q,4),f)+"</div>";l+="</devsite-analytics-scope></div>"}l+=0<_ds.T(h).length&&0<_ds.T(b).length+_ds.T(d).length?'<hr role="none">':"";if(0<_ds.T(h).length){l=l+'<div class="devsite-suggest-sub-section" role="listitem"><div class="devsite-suggest-header" id="devsite-suggest-header-reference" role="heading" aria-level="2">\u53c2\u8003\u9875\u9762'+
((f?'<span class="devsite-suggest-project">'+_ds.S(e)+"</span>":"")+'</div><devsite-analytics-scope category="Site-Wide Custom Events" label="Search" role="list" aria-labelledby="devsite-suggest-header-reference" action="Reference Suggestion Click">');m=h.length;for(n=0;n<m;n++)q=h[n],l+='<div class="devsite-result-item devsite-nav-label" id="suggestion-reference-'+_ds.X(n)+'" role="listitem" index=":'+_ds.X(n)+'">'+k7(q.getPath(),q.getTitle(),_ds.hg(q,14),"Reference Suggestion Click",_ds.z(q,3),
_ds.z(q,4),f,_ds.Pc(q,10,_ds.mc)[0])+"</div>";l+="</devsite-analytics-scope></div>"}l+=0<_ds.T(c).length&&0<_ds.T(b).length+_ds.T(d).length+_ds.T(h).length?'<hr role="none">':"";if(0<_ds.T(c).length){l+='<div class="devsite-suggest-sub-section" role="listitem"><div class="devsite-suggest-header" id="devsite-suggest-header-other-products" role="heading" aria-level="2"><span role="columnheader">\u4ea7\u54c1</span></div><devsite-analytics-scope category="Site-Wide Custom Events" label="Search" role="list" aria-labelledby="devsite-suggest-header-other-products" action="Product Suggestion Click">';
b=c.length;for(d=0;d<b;d++)h=c[d],l+='<div class="devsite-result-item devsite-nav-label" id="suggestion-other-products-'+_ds.X(d)+'" role="listitem" index=":'+_ds.X(d)+'">'+k7(h.getPath(),h.getTitle(),_ds.hg(h,14),"Product Suggestion Click")+"</div>";l+="</devsite-analytics-scope></div>"}l+="</div>"+(k?'<div class="devsite-suggest-footer">'+(f?i7(e):"")+j7(g,f,a)+"</div>":"")+"</div>";return(0,_ds.R)(l)};var Jea=/[ .()<>{}\[\]\/:,]+/,Kea=0,Nea=function(a){a.g&&(a.h.listen(a.g,"suggest-service-search",b=>{a:{var c=a.ma.querySelector(".highlight");if(c&&(c=c.querySelector(".devsite-result-item-link"))){c.click();break a}l7(a,b.detail.originalEvent,!!a.qa)}}),a.h.listen(a.g,"suggest-service-suggestions-received",b=>void Lea(a,b)),a.h.listen(a.g,"suggest-service-focus",()=>{m7(a,"cloud-track-search-focus",null);a.ua=!0;n7(a,!0)}),a.h.listen(a.g,"suggest-service-blur",()=>{n7(a,!1)}),a.h.listen(a.g,"suggest-service-input",
()=>{!a.oa["Text Entered Into Search Bar"]&&a.g.query.trim()&&(a.dispatchEvent(new CustomEvent("devsite-analytics-observation",{detail:{category:"Site-Wide Custom Events",label:"Search",action:"Text Entered Into Search Bar"},bubbles:!0})),a.oa["Text Entered Into Search Bar"]=!0);a.ua&&(m7(a,"cloud-track-search-input",null),a.ua=!1)}),a.h.listen(a.g,"suggest-service-navigate",b=>void Mea(a,b)),a.h.listen(document.body,"devsite-page-changed",()=>a.oa={}),_ds.JI(a.g));a.o&&a.h.listen(a.o,"submit",b=>
{l7(a,b)});a.ma&&a.h.listen(a.ma,"click",b=>{const c=b.target;if(c.closest(".devsite-result-item-link")){n7(a,!1);let d;m7(a,"cloud-track-search-submit",{query:null==(d=a.v)?void 0:d.value,FF:c})}c.classList.contains("devsite-search-project-scope")&&l7(a,b,!0)});a.Da&&a.h.listen(a.Da,"click",()=>void n7(a,!0));a.xa&&a.h.listen(a.xa,"click",()=>void n7(a,!1))},Lea=function(a,b){b=b.detail;var c=b.suggestions;b=b.query;if(a.g.query.toLowerCase().startsWith(b.toLowerCase()))if(c){var d=c.Qd();c=d.filter(q=>
2===q.Mf());var e=d.filter(q=>3===q.Mf()),f=d.filter(q=>4===q.Mf()).slice(0,5),g=d.filter(q=>1===q.Mf());d=c.length+f.length+g.length;for(var h of f)h.setPath(_ds.Hk(`${a.qa||"/s/results"}/?q=${h.getTitle()}`).toString());var k=b.split(Jea);e.forEach(q=>_ds.XG(q,_ds.Pc(q,10,_ds.mc).filter(r=>k.some(w=>r.includes(w)))));h=a.getAttribute("project-name")||"";var l=a.hasAttribute("project-scope"),m=a.hasAttribute("enable-search"),n=a.getAttribute("tenant-name")||"";c={Ow:c,projectName:h,Tq:l,Xw:g,hx:f,
query:b,mx:e,Yq:m,zk:n};0===d?_ds.N(a.ea,Hea,c):(_ds.N(a.ea,Iea,c),Oea(a,b));a.setAttribute("aria-expanded","true");a.ea.removeAttribute("hidden")}else a.ea.setAttribute("hidden",""),a.setAttribute("aria-expanded","false")},m7=function(a,b,c=null){a.dispatchEvent(new CustomEvent(b,{detail:c,bubbles:!0}))},n7=function(a,b){if(a.ra!==b){_ds.FI(a.g,b);if(a.ra=b)a.setAttribute("search-active","");else{let c=a.ma.querySelector(".highlight");c&&c.classList.remove("highlight");a.removeAttribute("search-active");
a.setAttribute("aria-expanded","false");_ds.rj(a.ea)}a.hasAttribute("capture")||a.dispatchEvent(new CustomEvent("devsite-search-toggle",{detail:{active:b},bubbles:!0}))}},Mea=function(a,b){var c=b.detail;b=a.ea.querySelector(".highlight");let d;const e=Array.from(a.ea.querySelectorAll(".devsite-result-item"));let f=[];let g,h=-1;if(b){var k=_ds.Kj(b,l=>l.classList.contains("devsite-suggest-section"));f=Array.from(k.querySelectorAll(".devsite-result-item"));k=_ds.yj(b.parentNode.parentNode);g=_ds.zj(b.parentNode.parentNode);
h=e.indexOf(b)}switch(c.keyCode){case 37:if(!k&&!g)return;b&&(c=b.getAttribute("index"),g?(d=g.querySelector('[index="'+c+'"]'))||(d=_ds.ab(Array.from(g.querySelectorAll("[index]")))):k&&((d=k.querySelector('[index="'+c+'"]'))||(d=_ds.ab(Array.from(k.querySelectorAll("[index]"))))));break;case 39:if(!k&&!g)return;b&&(c=b.getAttribute("index"),k?(d=k.querySelector('[index="'+c+'"]'))||(d=_ds.ab(Array.from(k.querySelectorAll("[index]")))):g&&((d=g.querySelector('[index="'+c+'"]'))||(d=_ds.ab(Array.from(g.querySelectorAll("[index]"))))));
break;case 38:b?(d=e[h-1])||(d=_ds.ab(f)):d=_ds.ab(e);break;case 40:b?(d=e[h+1])||(d=f[0]):d=e[0]}b&&(b.classList.remove("highlight"),b.removeAttribute("aria-selected"));d&&(a.v.setAttribute("aria-activedescendant",d.id),d.setAttribute("aria-selected","true"),d.classList.add("highlight"),d.scrollIntoViewIfNeeded&&d.scrollIntoViewIfNeeded()||d.scrollIntoView())},l7=async function(a,b,c=!1){b.preventDefault();b.stopPropagation();if(a.hasAttribute("enable-search")){a.oa["Full Site Search"]||(a.dispatchEvent(new CustomEvent("devsite-analytics-observation",
{detail:{category:"Site-Wide Custom Events",label:"Search",action:"Full Site Search"},bubbles:!0})),a.oa["Full Site Search"]=!0);let d;m7(a,"cloud-track-search-submit",{query:null==(d=a.v)?void 0:d.value});b=c&&a.qa?_ds.Hk(a.qa):_ds.Hk(a.o.getAttribute("action"));c=new _ds.bk(b.href);a.g.query&&_ds.ok(c,"q",a.g.query);b.search=c.g.toString();await DevsiteApp.fetchPage(b.href,!a.hasAttribute("disable-history"));n7(a,!1)}},Oea=function(a,b){b=new RegExp(`(${_ds.Vi(b)})`,"ig");a=a.ea.querySelectorAll(".devsite-suggestion-fragment");
for(const c of a)a=c.innerHTML,a=a.replace(b,"<b>$1</b>"),_ds.Ed(c,_ds.gi(a))},o7=class extends _ds.D{static get observedAttributes(){return["project-scope","url-scoped","disabled"]}constructor(){super();this.ra=!1;this.oa={};this.va="";this.qa=null;this.h=new _ds.F;this.g=null;this.ua=!1}disconnectedCallback(){_ds.H(this.h);this.g&&(this.g.dispose(),this.g=null)}attributeChangedCallback(a,b,c){switch(a){case "project-scope":this.va=c||"";this.g&&(this.g.ra=this.va);break;case "url-scoped":this.qa=
c;break;case "disabled":this.v&&(this.v.disabled=null!==c)}}connectedCallback(){if(this.o=this.querySelector("form")){this.v=this.o.querySelector(".devsite-search-query");this.Da=this.o.querySelector(".devsite-search-button[search-open]");this.xa=this.querySelector(".devsite-search-button[search-close]");var a=`devsite-search-popout-container-id-${++Kea}`;this.v.setAttribute("aria-controls",a);this.ma=_ds.O(Gea,{id:a});this.ea=this.ma.querySelector(".devsite-suggest-results-container");this.o.appendChild(this.ma);
this.hasAttribute("project-scope")&&(this.va=this.getAttribute("project-scope"));this.hasAttribute("url-scoped")&&(this.qa=this.getAttribute("url-scoped"));this.o&&this.v&&(this.g=new _ds.KI(this,this.o,this.v),this.g.j=!0,this.g.Fa=this.hasAttribute("enable-query-completion"),this.g.ua=!0,this.g.Ba=!0,this.g.Aa=!0,this.g.ra=this.va,this.g.j=this.hasAttribute("enable-suggestions"));Nea(this)}}};o7.prototype.connectedCallback=o7.prototype.connectedCallback;o7.prototype.attributeChangedCallback=o7.prototype.attributeChangedCallback;
o7.prototype.disconnectedCallback=o7.prototype.disconnectedCallback;try{window.customElements.define("devsite-search",o7)}catch(a){console.warn("devsite.app.customElement.DevsiteSearch",a)};})(_ds_www);
