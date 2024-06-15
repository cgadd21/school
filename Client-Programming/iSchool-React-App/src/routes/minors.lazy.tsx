import { createLazyFileRoute } from '@tanstack/react-router';
import { Minors } from '../components/pages/minors/minors';

/** Lazy load minors route. */
export const Route = createLazyFileRoute('/minors')({
  component: Minors,
});
