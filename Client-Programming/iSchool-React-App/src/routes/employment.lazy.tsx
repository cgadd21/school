import { createLazyFileRoute } from '@tanstack/react-router';
import { Employment } from '../components/pages/employment/employment';

/** Lazy load employment route. */
export const Route = createLazyFileRoute('/employment')({
  component: Employment,
});
