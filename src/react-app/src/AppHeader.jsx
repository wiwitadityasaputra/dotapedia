
function AppHeader() {
    return (
        <header className="nk-header nk-header-opaque App">
        <nav className="nk-navbar nk-navbar-top nk-navbar-sticky nk-navbar-autohide">
          <div className="container">
            <div className="nk-nav-table">
              <a href="" className="nk-nav-logo dp-nav-home">
                <img src="assets/image/dotapedia.png" alt="DotaPedia" width="199" />
              </a>
              <ul className="nk-nav nk-nav-right d-none d-lg-table-cell" data-nav-mobile="#nk-nav-mobile">
                <li>
                  <a className="dp-nav-tournament" href="" >Tournament</a>
                </li>
                <li>
                  <a className="dp-nav-team" href="" >Team</a>
                </li>
                <li>
                  <a className="dp-nav-player" href="" >Players</a>
                </li>
                <li>
                  <a className="dp-nav-hero" href="" >Hero</a>
                </li>
                <li>
                  <a className="dp-nav-schedule" href="" >Schedule</a>
                </li>
                <li>
                  <a className="dp-nav-news" href="" >News</a>
                </li>
              </ul>
              <ul className="nk-nav nk-nav-right nk-nav-icons">
                <li className="single-icon d-lg-none">
                    <a href="#" className="no-link-effect" data-nav-toggle="#nk-nav-mobile">
                        <span className="nk-icon-burger">
                            <span className="nk-t-1"></span>
                            <span className="nk-t-2"></span>
                            <span className="nk-t-3"></span>
                        </span>
                    </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
    );
}

export default AppHeader;