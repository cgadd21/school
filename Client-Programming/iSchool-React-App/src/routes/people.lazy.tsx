import { createLazyFileRoute } from '@tanstack/react-router';
import { People } from '../components/pages/people/people';

/** Lazy load people route. */
export const Route = createLazyFileRoute('/people')({
  component: People,
});
