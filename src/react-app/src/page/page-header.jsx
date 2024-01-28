import { NavLink } from 'react-router-dom';

function PageHeader() {
    return (
        <header className="nk-header nk-header-opaque App">
        <nav className="nk-navbar nk-navbar-top nk-navbar-sticky nk-navbar-autohide">
          <div className="container">
            <div className="nk-nav-table">
              <NavLink to="/home" className={"nk-nav-logo dp-nav-home"}>
                <img src="assets/image/dotapedia.png" alt="DotaPedia" width="199" />
              </NavLink>
              <ul className="nk-nav nk-nav-right d-none d-lg-table-cell" data-nav-mobile="#nk-nav-mobile">
                <li>
                  <NavLink to="/tournaments">Tournament</NavLink>
                </li>
                <li>
                  <NavLink to="/teams">Team</NavLink>
                </li>
                <li>
                  <NavLink to="/players">Players</NavLink>
                </li>
                <li>
                  <NavLink to="/heroes">Heroes</NavLink>
                </li>
                <li>
                  <NavLink to="/schedule">Schedule</NavLink>
                </li>
                <li>
                  <NavLink to="/news">News</NavLink>
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

export default PageHeader;