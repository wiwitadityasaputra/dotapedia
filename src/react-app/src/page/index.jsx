import { Routes, Route } from 'react-router-dom';
import Home from './home';
import Tournament from './tournament';
import Team from './team';
import Player from './player';
import Hero from './hero';
import Schedule from './schedule';
import News from './news';
import PageHeader from './page-header';
import PageTittle from './page-tittle';

function Page() {
  return (
    <>
      <PageHeader></PageHeader>
      <PageTittle></PageTittle>
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/tournaments" element={<Tournament />} />
        <Route path="/teams" element={<Team />} />
        <Route path="/players" element={<Player />} />
        <Route path="/heroes" element={<Hero />} />
        <Route path="/schedule" element={<Schedule />} />
        <Route path="/news" element={<News />} />
      </Routes>
    </>
  );
}

export default Page;
