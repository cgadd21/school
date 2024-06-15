import { createLazyFileRoute } from '@tanstack/react-router';
import { About } from '../components/pages/about/about';

/** Lazy load about route. */
export const Route = createLazyFileRoute('/about')({
  component: About,
});
