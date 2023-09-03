(function(_ds){var window=this;var Daa=_ds.Mz([".icon-arrow,.icon-language{fill:var(--devsite-secondary-text-color)}:host{display:block;position:relative}*{-moz-box-sizing:border-box;box-sizing:border-box}[hidden]{display:none}button{-moz-appearance:none;-webkit-appearance:none;-webkit-box-align:center;-webkit-align-items:center;-moz-box-align:center;-ms-flex-align:center;align-items:center;background-color:var(--devsite-select-background-color,var(--devsite-background-1));border:var(--devsite-select-border,var(--devsite-secondary-border));border-radius:var(--devsite-select-border-radius);box-shadow:none;color:var(--devsite-select-color,var(--devsite-primary-text-color));cursor:pointer;display:-webkit-box;display:-webkit-flex;display:-moz-box;display:-ms-flexbox;display:flex;font:var(--devsite-select-font,500 14px/36px var(--devsite-primary-font-family));height:36px;max-width:154px;outline:0;padding-block:0;padding-inline:11px 7px;-webkit-transition:background-color .2s;transition:background-color .2s}button:is(:hover,:focus){background:var(--devsite-select-background-color-hover,var(--devsite-background-3))}.icon-arrow,.icon-language{block-size:24px;inline-size:24px;pointer-events:none}.icon-language{margin-inline:0 8px}.label{overflow:hidden;text-overflow:ellipsis;white-space:nowrap}[role=menu]{background:var(--devsite-background-1);border:var(--devsite-list-border,var(--devsite-secondary-border));border-radius:var(--devsite-list-border-radius,2px);box-shadow:0 1px 2px 0 var(--devsite-elevation-key-shadow-color),0 2px 6px 2px var(--devsite-elevation-ambient-shadow-color);inset-inline:var(--devsite-language-selector-menu-inset-inline,0 auto);max-height:304px;overflow:hidden auto;padding:8px 0;position:absolute;top:36px;-webkit-transform:var(--devsite-language-selector-menu-transform);transform:var(--devsite-language-selector-menu-transform);z-index:1}"]);var P4=function(a){a.links=[...a.querySelectorAll("a")];a.h=a.links.length-1;const b=_ds.E(),c=new URLSearchParams(b.search);c.delete("hl");for(const d of a.links){a=d.getAttribute("lang");const e=a.toLowerCase().replaceAll("_","-");_ds.Fd([(0,_ds.u)`lang`],d,"lang",e);"en"!==a&&c.set("hl",e);b.search=c.toString();_ds.Bd(d,_ds.Td(b.href))}},Eaa=async function(a){if(a.g.get("django_language")){var b;const c=null==(b=a.querySelector("[aria-current]"))?void 0:b.textContent;c&&(a.zc=c)}else b=await _ds.v(),
a.g.set("django_language",b.getLocale()||"en",{Pc:15552E3,path:"/"}),(a=a.querySelector('[lang="en"]'))&&_ds.Fd([(0,_ds.u)`aria-`],a,"aria-current","true")},Q4=async function(a){const b=a.g.get("django_language");b&&await a.ra.set("language_preference",b)},Faa=function(a){a.eventHandler.listen(document.body,"click",b=>{b.target!==a&&(a.open=!1,_ds.H(a.eventHandler))});a.eventHandler.listen(document.body,"keydown",b=>{"Escape"===b.key&&(a.open=!1,_ds.H(a.eventHandler),a.toggle.focus())})},Gaa=async function(a,
b,c){a.dispatchEvent(new CustomEvent("devsite-analytics-observation",{detail:{category:"Site-Wide Custom Events",label:"Language Selector",action:`${b} to ${c}`},bubbles:!0}));b={eventData:JSON.stringify({name:"change",type:"languageSelector",metadata:{"selected-language":`${c}`,"original-language":`${b}`}})};a.dispatchEvent(new CustomEvent("devsite-analytics-observation-cloudtrack",{detail:b,bubbles:!0}))},Haa=async function(a,b){const c=b.target.getAttribute("lang");c&&(b.stopPropagation(),await _ds.v(),
a.g.remove("django_language"),a.g.set("django_language",c,{Pc:15552E3,path:"/"}),(b=document.documentElement.getAttribute("lang"))&&await Gaa(a,b,c),await Q4(a),a=new URL(_ds.lj().location.toString()),a.searchParams.delete("hl"),_ds.Md(_ds.lj().location,_ds.Td(a.toString())))},R4=class extends _ds.kA{constructor(){super(...arguments);this.g=new _ds.Hx;this.eventHandler=new _ds.F;this.links=[];this.h=0;this.ra=_ds.Vm();this.ariaLabel="\u9009\u62e9\u60a8\u7684\u8bed\u8a00\u504f\u597d\u8bbe\u7f6e\u3002";
this.open=!1;this.zc="Language"}static get styles(){return Daa}async cc(){P4(this);try{await Eaa(this),await Q4(this)}catch(a){}}async o(){if(this.open=!this.open){await this.qa;let a;null==(a=this.querySelector("[aria-current]"))||a.focus();Faa(this)}else _ds.H(this.eventHandler)}render(){return(0,_ds.Q)`
      <button type="button"
              aria-controls="language-menu"
              aria-haspopup="true"
              @click="${this.o}">
        <svg
          aria-hidden="true"
          class="icon-language"
          viewbox="0 0 24 24"
          xmlns="http://www.w3.org/2000/svg">
          <path d="M12 22q-2.05 0-3.875-.788-1.825-.787-3.187-2.15-1.363-1.362-2.15-3.187Q2 14.05 2 12q0-2.075.788-3.887.787-1.813 2.15-3.175Q6.3 3.575 8.125 2.787 9.95 2 12 2q2.075 0 3.887.787 1.813.788 3.175 2.151 1.363 1.362 2.15 3.175Q22 9.925 22 12q0 2.05-.788 3.875-.787 1.825-2.15 3.187-1.362 1.363-3.175 2.15Q14.075 22 12 22Zm0-2.05q.65-.9 1.125-1.875T13.9 16h-3.8q.3 1.1.775 2.075.475.975 1.125 1.875Zm-2.6-.4q-.45-.825-.787-1.713Q8.275 16.95 8.05 16H5.1q.725 1.25 1.812 2.175Q8 19.1 9.4 19.55Zm5.2 0q1.4-.45 2.487-1.375Q18.175 17.25 18.9 16h-2.95q-.225.95-.562 1.837-.338.888-.788 1.713ZM4.25 14h3.4q-.075-.5-.113-.988Q7.5 12.525 7.5 12t.037-1.012q.038-.488.113-.988h-3.4q-.125.5-.188.988Q4 11.475 4 12t.062 1.012q.063.488.188.988Zm5.4 0h4.7q.075-.5.113-.988.037-.487.037-1.012t-.037-1.012q-.038-.488-.113-.988h-4.7q-.075.5-.112.988Q9.5 11.475 9.5 12t.038 1.012q.037.488.112.988Zm6.7 0h3.4q.125-.5.188-.988Q20 12.525 20 12t-.062-1.012q-.063-.488-.188-.988h-3.4q.075.5.112.988.038.487.038 1.012t-.038 1.012q-.037.488-.112.988Zm-.4-6h2.95q-.725-1.25-1.813-2.175Q16 4.9 14.6 4.45q.45.825.788 1.712.337.888.562 1.838ZM10.1 8h3.8q-.3-1.1-.775-2.075Q12.65 4.95 12 4.05q-.65.9-1.125 1.875T10.1 8Zm-5 0h2.95q.225-.95.563-1.838.337-.887.787-1.712Q8 4.9 6.912 5.825 5.825 6.75 5.1 8Z"/>
        </svg>
        <span class="label">${this.zc}</span>
        <svg
          aria-hidden="true"
          class="icon-arrow"
          viewbox="0 0 24 24"
          xmlns="http://www.w3.org/2000/svg">
          <path d="m12 15-5-5h10Z"/>
        </svg>
      </button>
      <div id="language-menu"
           role="menu"
           @click="${a=>void Haa(this,a)}"
           @keydown="${a=>{if("ArrowUp"===a.key||"ArrowDown"===a.key){a.preventDefault();let b=0;const c=document.activeElement;c&&(b=this.links.indexOf(c));b="ArrowUp"===a.key?0===b?this.h:b-1:b===this.h?0:b+1;this.links[b].focus()}}}"
           ?hidden=${!this.open}>
        <slot></slot>
      </div>`}Wb(a){if(a&&(a=a.querySelector("ul"))){let b;null==(b=this.querySelector("ul"))||b.remove();this.append(a);P4(this);_ds.$z(this)}}};_ds.x([_ds.K({type:String,Ha:"aria-label",Ua:!0}),_ds.y(Object)],R4.prototype,"ariaLabel",void 0);_ds.x([_ds.K({type:Boolean,Ua:!0}),_ds.y(Object)],R4.prototype,"open",void 0);_ds.x([_ds.M(),_ds.y(Object)],R4.prototype,"zc",void 0);_ds.x([_ds.Zp("button"),_ds.y(HTMLButtonElement)],R4.prototype,"toggle",void 0);try{window.customElements.define("devsite-language-selector",R4)}catch(a){console.warn("devsite.app.customElement.DevsiteLanguageSelector",a)};})(_ds_www);
