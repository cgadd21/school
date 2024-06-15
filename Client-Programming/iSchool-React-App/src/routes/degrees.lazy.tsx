import { createLazyFileRoute } from '@tanstack/react-router';
import { Degrees } from '../components/pages/degrees/degrees';

/** Lazy load degrees route. */
export const Route = createLazyFileRoute('/degrees')({
  component: Degrees,
});
