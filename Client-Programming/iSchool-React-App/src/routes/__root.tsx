import { createRootRoute, Link, Outlet } from '@tanstack/react-router';
import { Theme } from '../components/theme/theme';

/** Represents the structure of a route. */
type Route = {
  title: string;
  href: string;
};

/** Represents the routes. */
const routes: Route[] = [
  {
    title: 'iSchool @ RIT',
    href: '/',
  },
  {
    title: 'Degrees',
    href: '/degrees',
  },
  {
    title: 'Minors',
    href: '/minors',
  },
  {
    title: 'Employment',
    href: '/employment',
  },
  {
    title: 'People',
    href: '/people',
  },
  {
    title: 'About',
    href: '/about',
  },
];

/** Root route configuration and layout for the application. */
export const Route = createRootRoute({
  component: () => {
    return (
      <>
        <div className="navbar bg-base-100 flex justify-around">
          {routes.map((route, idx) => (
            <Link
              to={route.href}
              key={idx}
              className="[&.active]:underline btn btn-ghost text-xl"
            >
              {route.title}
            </Link>
          ))}
          <Theme />
        </div>
        <Outlet />
      </>
    );
  },
});
